package com.prenetics.properties;

import static io.restassured.RestAssured.given;
import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import java.lang.reflect.Method;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterMethod;
import com.prenetics.common.utility.TestBaseClass;
import com.prenetics.swagger.testing.invoker.GsonObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;

public abstract class RestAssuredBaseClass extends TestBaseClass {

	private final RestAssuredTestService testService = new RestAssuredTestService(this::getUtils, getRequestLogLevel());

	protected LogDetail getRequestLogLevel() {
		return LogDetail.ALL;
	}

	protected RestAssuredTestService getTestService() {
		return testService;
	}

	protected void deleteCustomer(String account) {
		this.testService.deleteCustomer(account);
	}

	protected RequestSpecBuilder createRequestSpecificationBuilder() {
		return createRequestSpecificationBuilder(getUtils().getProps().testBaseUrl());
	}

	protected RequestSpecBuilder createRequestSpecificationBuilder(String baseUrl) {
		return new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri(baseUrl).log(getRequestLogLevel());
	}

	protected void setRequestSpecification() {
		this.setRequestSpecification(getUtils().getProps().testBaseUrl());
	}

	protected void setRequestSpecification(String baseUrl) {
		RestAssured.requestSpecification = createRequestSpecificationBuilder(baseUrl).build();
	}

	/**
	 * Get service account
	 * 
	 * @param accessToken
	 * @return
	 */

	@Override
	public String login(String email, String password) {
		String accessToken = given().header("Content-Type", "application/json")
				.body(getInfo().getLoginRequestBody(email, password)).when().post(getInfo().getLoginEndpoint()).then()
				.assertThat().body("access_token", not(isEmptyOrNullString())).log().all().and().extract().response()
				.getBody().jsonPath().get("access_token");
		return accessToken;
	}

	@Override
	public String getBarcode(String provider) {
		return getTestService().getOrCreateBarcode(provider);
	}

	@Override
	public String getCustomerBarcode(String accessToken) {
		String barcode = given().header("X-Access-Token", accessToken).when().get(getInfo().getTrackKitEndPoint())
				.then().assertThat().log().all().statusCode(HttpStatus.SC_OK).extract().response().jsonPath()
				.getString("track_kit.kit");
		return barcode;
	}

	@Override
	public void activate(String barcode, String email, String password) {
		given().header("Content-Type", "application/json")
				.body(getInfo().getRegisterRequestBody(barcode, email, password)).when()
				.post(getInfo().getRegisterEndpoint()).then().log().all().assertThat()
				.statusCode(HttpStatus.SC_CREATED);
	}

	@Override
	public void testSetup(Method method) {
		RestAssured.config = RestAssuredConfig.newConfig()
				.objectMapperConfig(objectMapperConfig().defaultObjectMapper(GsonObjectMapper.gson()))
				.logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails().enablePrettyPrinting(true));
		this.setRequestSpecification();
		test = extent.createTest(method.getName());
	}

	@AfterMethod
	public void tearDown() {
		/**
		 * Ensure other tests baseURL does not get overridden
		 */
		RestAssured.requestSpecification = null;
	}

}
