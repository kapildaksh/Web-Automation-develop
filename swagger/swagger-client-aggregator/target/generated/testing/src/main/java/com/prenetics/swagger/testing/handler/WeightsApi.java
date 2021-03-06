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
import com.prenetics.swagger.testing.model.WeightReset;

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

public class WeightsApi {

    private RequestSpecBuilder reqSpec;

    private WeightsApi(RequestSpecBuilder reqSpec) {
        this.reqSpec = reqSpec;
    }

    public static WeightsApi weights(RequestSpecBuilder reqSpec) {
        return new WeightsApi(reqSpec);
    }


    public DeleteWeightsOper deleteWeights() {
        return new DeleteWeightsOper(reqSpec);
    }

    /**
    * Customise request specification
    */
    public WeightsApi reqSpec(Consumer<RequestSpecBuilder> consumer) {
        consumer.accept(reqSpec);
        return this;
    }

    /**
     * Delete all weight logs
     * Delete weight logs
     *
     * @see #body service account (required)
     */
    public class DeleteWeightsOper {

        public static final String REQ_URI = "/v1.0/weight_log";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public DeleteWeightsOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public DeleteWeightsOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * DELETE /v1.0/weight_log
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(DELETE, REQ_URI));
        }

         /**
         * @param body (WeightReset) service account (required)
         */
        public DeleteWeightsOper body(WeightReset body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * Customise request specification
         */
        public DeleteWeightsOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public DeleteWeightsOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
}