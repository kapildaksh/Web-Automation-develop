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

import com.prenetics.swagger.testing.model.ErrorResponse;
import com.prenetics.swagger.testing.model.Food;
import com.prenetics.swagger.testing.model.FoodList;
import com.prenetics.swagger.testing.model.FoodReset;
import com.prenetics.swagger.testing.invoker.ApiClient;
import com.prenetics.swagger.testing.handler.FoodApi;
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
 * API tests for FoodApi
 */
@Ignore
public class FoodApiTest {

    private FoodApi api;

    @Before
    public void createApi() {
        api = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder().setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).food();
    }

    /**
     * food logs added
     */
    @Test
    public void shouldSee201AfterAddAllFoods() {
        FoodList body = null;
        api.addAllFoods()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterAddAllFoods() {
        FoodList body = null;
        api.addAllFoods()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterAddAllFoods() {
        FoodList body = null;
        api.addAllFoods()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * food logs removed
     */
    @Test
    public void shouldSee201AfterDeleteFoods() {
        FoodReset body = null;
        api.deleteFoods()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterDeleteFoods() {
        FoodReset body = null;
        api.deleteFoods()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterDeleteFoods() {
        FoodReset body = null;
        api.deleteFoods()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * food log updated
     */
    @Test
    public void shouldSee204AfterUpdateFood() {
        Integer foodLogId = null;
        Food body = null;
        api.updateFood()
                .foodLogIdPath(foodLogId)
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterUpdateFood() {
        Integer foodLogId = null;
        Food body = null;
        api.updateFood()
                .foodLogIdPath(foodLogId)
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterUpdateFood() {
        Integer foodLogId = null;
        Food body = null;
        api.updateFood()
                .foodLogIdPath(foodLogId)
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

}