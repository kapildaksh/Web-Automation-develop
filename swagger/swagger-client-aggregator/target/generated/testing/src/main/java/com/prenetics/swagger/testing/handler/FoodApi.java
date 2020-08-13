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

import com.google.gson.reflect.TypeToken;
import com.prenetics.swagger.testing.model.ErrorResponse;
import com.prenetics.swagger.testing.model.Food;
import com.prenetics.swagger.testing.model.FoodList;
import com.prenetics.swagger.testing.model.FoodReset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import com.prenetics.swagger.testing.invoker.JSON;

import static io.restassured.http.Method.*;

public class FoodApi {

    private RequestSpecBuilder reqSpec;

    private FoodApi(RequestSpecBuilder reqSpec) {
        this.reqSpec = reqSpec;
    }

    public static FoodApi food(RequestSpecBuilder reqSpec) {
        return new FoodApi(reqSpec);
    }


    public AddAllFoodsOper addAllFoods() {
        return new AddAllFoodsOper(reqSpec);
    }

    public DeleteFoodsOper deleteFoods() {
        return new DeleteFoodsOper(reqSpec);
    }

    public UpdateFoodOper updateFood() {
        return new UpdateFoodOper(reqSpec);
    }

    /**
    * Customise request specification
    */
    public FoodApi reqSpec(Consumer<RequestSpecBuilder> consumer) {
        consumer.accept(reqSpec);
        return this;
    }

    /**
     * Add food logs
     * Add food logs
     *
     * @see #body food list (required)
     */
    public class AddAllFoodsOper {

        public static final String REQ_URI = "/v1.0/food_log";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public AddAllFoodsOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public AddAllFoodsOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * POST /v1.0/food_log
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI));
        }

         /**
         * @param body (FoodList) food list (required)
         */
        public AddAllFoodsOper body(FoodList body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * Customise request specification
         */
        public AddAllFoodsOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public AddAllFoodsOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Delete all food logs
     * Delete food logs
     *
     * @see #body service account (required)
     */
    public class DeleteFoodsOper {

        public static final String REQ_URI = "/v1.0/food_log";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public DeleteFoodsOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public DeleteFoodsOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * DELETE /v1.0/food_log
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(DELETE, REQ_URI));
        }

         /**
         * @param body (FoodReset) service account (required)
         */
        public DeleteFoodsOper body(FoodReset body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * Customise request specification
         */
        public DeleteFoodsOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public DeleteFoodsOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Update a food log
     * Update a food log
     *
     * @see #foodLogIdPath Food Log Id (required)
     * @see #body food log (required)
     */
    public class UpdateFoodOper {

        public static final String REQ_URI = "/v1.0/food_log/{food_log_id}";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public UpdateFoodOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public UpdateFoodOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * PATCH /v1.0/food_log/{food_log_id}
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(PATCH, REQ_URI));
        }

         /**
         * @param body (Food) food log (required)
         */
        public UpdateFoodOper body(Food body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * @param foodLogId (Integer) Food Log Id (required)
         */
        public UpdateFoodOper foodLogIdPath(Object foodLogId) {
            reqSpec.addPathParam("food_log_id", foodLogId);
            return this;
        }

        /**
         * Customise request specification
         */
        public UpdateFoodOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public UpdateFoodOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
}