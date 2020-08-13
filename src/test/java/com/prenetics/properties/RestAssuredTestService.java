package com.prenetics.properties;

import static com.prenetics.swagger.testing.invoker.ResponseSpecBuilders.shouldBeCode;
import static com.prenetics.swagger.testing.invoker.ResponseSpecBuilders.validatedWith;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.HttpStatus;

import com.prenetics.swagger.testing.invoker.ApiClient;
import com.prenetics.swagger.testing.invoker.ApiClient.Config;
import com.prenetics.swagger.testing.model.Challenge;
import com.prenetics.swagger.testing.model.Challenge.ChallengeTypeEnum;
import com.prenetics.swagger.testing.model.ChallengeList;
import com.prenetics.swagger.testing.model.ChallengeReset;
import com.prenetics.swagger.testing.model.Food;
import com.prenetics.swagger.testing.model.FoodList;
import com.prenetics.swagger.testing.model.FoodReset;
import com.prenetics.swagger.testing.model.Sleep;
import com.prenetics.swagger.testing.model.SleepList;
import com.prenetics.swagger.testing.model.SleepReset;
import com.prenetics.swagger.testing.model.StepReset;
import com.prenetics.swagger.testing.model.TrackKitRequest;
import com.prenetics.swagger.testing.model.WeightReset;
import com.prenetics.common.utility.Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class RestAssuredTestService {

	private final Supplier<Utilities> utilities;
	private final LogDetail logDetail;

	RestAssuredTestService(Supplier<Utilities> utilities, LogDetail logDetail) {
		this.utilities = utilities;
		this.logDetail = logDetail;
	}

	private RequestSpecBuilder createRequestSpecificationBuilder() {
		return createRequestSpecificationBuilder(getUtils().getProps().testBaseUrl());
	}

	private RequestSpecBuilder createRequestSpecificationBuilder(String baseUrl) {
		return new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri(baseUrl).log(logDetail).setContentType(ContentType.JSON);
	}

	public String getAvailabeAccount() {
		return getApiClient().customer().getAvailableAccount()
				.executeAs(validatedWith(shouldBeCode(HttpStatus.SC_CREATED))).getAccount();
	}

	public String getOrCreateBarcode(String provider) {
		try {
			return getBarcode(provider);
		} catch (AssertionError error) {
			return generateBarcode(provider);
		}
	}

	public String generateBarcode(String provider) {
		return getApiClient().lab().createBarcode().providerPath(provider)
				.executeAs(validatedWith(shouldBeCode(HttpStatus.SC_CREATED))).getCode();
	}
	
	public String getBarcode(String provider) {
		return getApiClient().lab().getBarcode().providerPath(provider)
				.executeAs(validatedWith(shouldBeCode(HttpStatus.SC_OK))).getCode();
	}

	public void deleteCustomer(String account) {
		getApiClient().customer().deleteCustomer().accountPath(account)
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_NO_CONTENT)));
	}

	public void resetChallenges(String serviceAccount) {
		getApiClient().challenge().resetChallenge().body(new ChallengeReset().serviceAccount(serviceAccount))
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_NO_CONTENT)));
	}

	public Challenge getChallenge(String serviceAccount, ChallengeTypeEnum type) {
		return getApiClient().challenge().getChallenge().serviceaccountPath(serviceAccount).typePath(type)
				.executeAs(validatedWith(shouldBeCode(HttpStatus.SC_OK)));
	}

	public ChallengeList getAllChallenges(String serviceAccount) {
		return getApiClient().challenge().getChallenges().serviceaccountPath(serviceAccount)
				.executeAs(validatedWith(shouldBeCode(HttpStatus.SC_OK)));
	}

	public void updateChallenges(String account, ChallengeList challenges) {
		getApiClient().challenge().updateChallenge().accountPath(account).body(challenges)
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_NO_CONTENT)));
	}

	public void addFoodLogs(String serviceAccount, Map<String, Integer> ratings) {
		getApiClient().food().addAllFoods()
				.body(new FoodList().foodLogList(ratings.entrySet().stream()
						.map(entry -> new Food().serviceAccount(serviceAccount).createdAt(entry.getKey())
								.rate(entry.getValue()).imageDescription("Food").imageUrl("http://localhost/image.jpg"))
						.collect(Collectors.toList())))
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_CREATED)));
	}

	public void addSleepLogs(String serviceAccount, Map<String, Pair<String, Integer>> durations) {
		getApiClient().sleeps().addAllSleeps()
				.body(new SleepList().sleepLogList(durations.entrySet().stream()
						.map(entry -> new Sleep().serviceAccount(serviceAccount).sleepTimeUtc(entry.getKey())
								.logDateLocal(entry.getKey()).wakeTimeUtc(entry.getValue().getLeft())
								.minute(entry.getValue().getRight()))
						.collect(Collectors.toList())))
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_CREATED)));
	}

	public void deleteAllFoods(String serviceAccount) {
		getApiClient().food().deleteFoods().body(new FoodReset().serviceAccount(serviceAccount))
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_NO_CONTENT)));
	}

	public void deleteAllSteps(String serviceAccount) {
		getApiClient().steps().deleteSteps().body(new StepReset().serviceAccount(serviceAccount))
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_NO_CONTENT)));
	}

	public void deleteAllWeights(String serviceAccount) {
		getApiClient().weights().deleteWeights().body(new WeightReset().serviceAccount(serviceAccount))
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_NO_CONTENT)));
	}

	public void deleteAllSleeps(String serviceAccount) {
		getApiClient().sleeps().deleteSleeps().body(new SleepReset().serviceAccount(serviceAccount))
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_NO_CONTENT)));
	}

	public void updateTrackKit(String account, TrackKitRequest request) {
		getApiClient().lab().updateKitStatus().accountPath(account).body(request)
				.execute(validatedWith(shouldBeCode(HttpStatus.SC_NO_CONTENT)));
	}

	private ApiClient getApiClient() {
		return getApiClient(this::createRequestSpecificationBuilder);
	}

	public ApiClient getApiClient(Supplier<RequestSpecBuilder> specificationBuilder) {
		return ApiClient.api(Config.apiConfig().reqSpecSupplier(specificationBuilder));
	}

	private Utilities getUtils() {
		return utilities.get();
	}

}
