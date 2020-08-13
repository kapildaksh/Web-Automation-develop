/*
 * Testing Service API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * Contact: devops@prenetics.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.prenetics.swagger.testing.handler;

import com.prenetics.swagger.testing.model.Challenge;
import com.prenetics.swagger.testing.model.ChallengeList;
import com.prenetics.swagger.testing.model.ChallengeReset;
import com.prenetics.swagger.testing.model.ErrorResponse;
import com.prenetics.swagger.testing.invoker.ApiClient;
import com.prenetics.swagger.testing.handler.ChallengeApi;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static com.prenetics.swagger.testing.invoker.GsonObjectMapper.gson;

/**
 * API tests for ChallengeApi
 */
@Ignore
public class ChallengeApiTest {

    private ChallengeApi api;

    @Before
    public void createApi() {
        api = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder().setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).challenge();
    }

    /**
     * Challenge
     */
    @Test
    public void shouldSee200AfterGetChallenge() {
        String serviceaccount = null;
        String type = null;
        api.getChallenge()
                .serviceaccountPath(serviceaccount)
                .typePath(type).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterGetChallenge() {
        String serviceaccount = null;
        String type = null;
        api.getChallenge()
                .serviceaccountPath(serviceaccount)
                .typePath(type).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterGetChallenge() {
        String serviceaccount = null;
        String type = null;
        api.getChallenge()
                .serviceaccountPath(serviceaccount)
                .typePath(type).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * Challenges
     */
    @Test
    public void shouldSee200AfterGetChallenges() {
        String serviceaccount = null;
        api.getChallenges()
                .serviceaccountPath(serviceaccount).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterGetChallenges() {
        String serviceaccount = null;
        api.getChallenges()
                .serviceaccountPath(serviceaccount).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterGetChallenges() {
        String serviceaccount = null;
        api.getChallenges()
                .serviceaccountPath(serviceaccount).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * challenges reset
     */
    @Test
    public void shouldSee204AfterResetChallenge() {
        ChallengeReset body = null;
        api.resetChallenge()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterResetChallenge() {
        ChallengeReset body = null;
        api.resetChallenge()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterResetChallenge() {
        ChallengeReset body = null;
        api.resetChallenge()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * updated challenges
     */
    @Test
    public void shouldSee204AfterUpdateChallenge() {
        String account = null;
        ChallengeList body = null;
        api.updateChallenge()
                .accountPath(account)
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterUpdateChallenge() {
        String account = null;
        ChallengeList body = null;
        api.updateChallenge()
                .accountPath(account)
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterUpdateChallenge() {
        String account = null;
        ChallengeList body = null;
        api.updateChallenge()
                .accountPath(account)
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

}