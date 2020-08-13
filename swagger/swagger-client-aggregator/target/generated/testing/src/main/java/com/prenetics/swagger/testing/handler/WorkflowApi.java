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
import java.math.BigDecimal;
import com.prenetics.swagger.testing.model.ErrorResponse;
import com.prenetics.swagger.testing.model.ExtractedSample;
import com.prenetics.swagger.testing.model.FileUpload;
import com.prenetics.swagger.testing.model.LabWorkflowStates;
import com.prenetics.swagger.testing.model.PrimarySample;
import com.prenetics.swagger.testing.model.Samples;
import com.prenetics.swagger.testing.model.TestRequest;
import com.prenetics.swagger.testing.model.UploadRequest;

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

public class WorkflowApi {

    private RequestSpecBuilder reqSpec;

    private WorkflowApi(RequestSpecBuilder reqSpec) {
        this.reqSpec = reqSpec;
    }

    public static WorkflowApi workflow(RequestSpecBuilder reqSpec) {
        return new WorkflowApi(reqSpec);
    }


    public CreateSampleOper createSample() {
        return new CreateSampleOper(reqSpec);
    }

    public CreateTestDataOper createTestData() {
        return new CreateTestDataOper(reqSpec);
    }

    public ExtractSampleOper extractSample() {
        return new ExtractSampleOper(reqSpec);
    }

    public GetLabWorkflowStatesOper getLabWorkflowStates() {
        return new GetLabWorkflowStatesOper(reqSpec);
    }

    public PrintSampleOper printSample() {
        return new PrintSampleOper(reqSpec);
    }

    public ResetLabWorkflowOper resetLabWorkflow() {
        return new ResetLabWorkflowOper(reqSpec);
    }

    public RetryLastLabWorkflowOper retryLastLabWorkflow() {
        return new RetryLastLabWorkflowOper(reqSpec);
    }

    public UploadResultOper uploadResult() {
        return new UploadResultOper(reqSpec);
    }

    /**
    * Customise request specification
    */
    public WorkflowApi reqSpec(Consumer<RequestSpecBuilder> consumer) {
        consumer.accept(reqSpec);
        return this;
    }

    /**
     * Create sample
     * Create sample
     *
     * @see #barcodePath barcode (required)
     * return PrimarySample
     */
    public class CreateSampleOper {

        public static final String REQ_URI = "/v1.0/lab/workflow/kit/{barcode}/sample";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public CreateSampleOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public CreateSampleOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * POST /v1.0/lab/workflow/kit/{barcode}/sample
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI));
        }

        /**
         * POST /v1.0/lab/workflow/kit/{barcode}/sample
         * @return PrimarySample
         */
        public PrimarySample executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<PrimarySample>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * @param barcode (String) barcode (required)
         */
        public CreateSampleOper barcodePath(Object barcode) {
            reqSpec.addPathParam("barcode", barcode);
            return this;
        }

        /**
         * Customise request specification
         */
        public CreateSampleOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public CreateSampleOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Create test data up to genotype upload
     * Create test data up to genotype upload
     *
     * @see #body body (required)
     * return Samples
     */
    public class CreateTestDataOper {

        public static final String REQ_URI = "/v1.0/lab/workflow/test_data";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public CreateTestDataOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public CreateTestDataOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * POST /v1.0/lab/workflow/test_data
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI));
        }

        /**
         * POST /v1.0/lab/workflow/test_data
         * @return Samples
         */
        public Samples executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<Samples>(){}.getType();
            return execute(handler).as(type);
        }

         /**
         * @param body (TestRequest) body (required)
         */
        public CreateTestDataOper body(TestRequest body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * Customise request specification
         */
        public CreateTestDataOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public CreateTestDataOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Extract sample
     * Extract sample
     *
     * @see #barcodePath barcode (required)
     * @see #samplePath sample (required)
     * return ExtractedSample
     */
    public class ExtractSampleOper {

        public static final String REQ_URI = "/v1.0/lab/workflow/kit/{barcode}/sample/{sample}/extraction";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public ExtractSampleOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public ExtractSampleOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * POST /v1.0/lab/workflow/kit/{barcode}/sample/{sample}/extraction
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI));
        }

        /**
         * POST /v1.0/lab/workflow/kit/{barcode}/sample/{sample}/extraction
         * @return ExtractedSample
         */
        public ExtractedSample executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<ExtractedSample>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * @param barcode (String) barcode (required)
         */
        public ExtractSampleOper barcodePath(Object barcode) {
            reqSpec.addPathParam("barcode", barcode);
            return this;
        }

        /**
         * @param sample (String) sample (required)
         */
        public ExtractSampleOper samplePath(Object sample) {
            reqSpec.addPathParam("sample", sample);
            return this;
        }

        /**
         * Customise request specification
         */
        public ExtractSampleOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public ExtractSampleOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Get lab workflow states
     * Get lab workflow states
     *
     * return LabWorkflowStates
     */
    public class GetLabWorkflowStatesOper {

        public static final String REQ_URI = "/v1.0/lab/workflow/available_states";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public GetLabWorkflowStatesOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public GetLabWorkflowStatesOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * GET /v1.0/lab/workflow/available_states
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(GET, REQ_URI));
        }

        /**
         * GET /v1.0/lab/workflow/available_states
         * @return LabWorkflowStates
         */
        public LabWorkflowStates executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<LabWorkflowStates>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * Customise request specification
         */
        public GetLabWorkflowStatesOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public GetLabWorkflowStatesOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Mark sample details printed
     * Mark sample details printed
     *
     * @see #barcodePath barcode (required)
     * @see #samplePath sample (required)
     */
    public class PrintSampleOper {

        public static final String REQ_URI = "/v1.0/lab/workflow/kit/{barcode}/sample/{sample}/print";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public PrintSampleOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public PrintSampleOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * PUT /v1.0/lab/workflow/kit/{barcode}/sample/{sample}/print
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(PUT, REQ_URI));
        }

        /**
         * @param barcode (String) barcode (required)
         */
        public PrintSampleOper barcodePath(Object barcode) {
            reqSpec.addPathParam("barcode", barcode);
            return this;
        }

        /**
         * @param sample (String) sample (required)
         */
        public PrintSampleOper samplePath(Object sample) {
            reqSpec.addPathParam("sample", sample);
            return this;
        }

        /**
         * Customise request specification
         */
        public PrintSampleOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public PrintSampleOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Reset customer lab workflow state
     * Reset customer lab workflow state
     *
     * @see #customerIdPath customer_id (required)
     */
    public class ResetLabWorkflowOper {

        public static final String REQ_URI = "/v1.0/lab/workflow/customer/{customer_id}/reset";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public ResetLabWorkflowOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public ResetLabWorkflowOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * DELETE /v1.0/lab/workflow/customer/{customer_id}/reset
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(DELETE, REQ_URI));
        }

        /**
         * @param customerId (BigDecimal) customer_id (required)
         */
        public ResetLabWorkflowOper customerIdPath(Object customerId) {
            reqSpec.addPathParam("customer_id", customerId);
            return this;
        }

        /**
         * Customise request specification
         */
        public ResetLabWorkflowOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public ResetLabWorkflowOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Remove pending tasks
     * Remove pending tasks
     *
     * @see #customerIdPath customer_id (required)
     */
    public class RetryLastLabWorkflowOper {

        public static final String REQ_URI = "/v1.0/lab/workflow/customer/{customer_id}/retry";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public RetryLastLabWorkflowOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public RetryLastLabWorkflowOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * DELETE /v1.0/lab/workflow/customer/{customer_id}/retry
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(DELETE, REQ_URI));
        }

        /**
         * @param customerId (BigDecimal) customer_id (required)
         */
        public RetryLastLabWorkflowOper customerIdPath(Object customerId) {
            reqSpec.addPathParam("customer_id", customerId);
            return this;
        }

        /**
         * Customise request specification
         */
        public RetryLastLabWorkflowOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public RetryLastLabWorkflowOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Upload test result
     * Upload test result
     *
     * @see #samplePath sample (required)
     * @see #body kit status (required)
     * return FileUpload
     */
    public class UploadResultOper {

        public static final String REQ_URI = "/v1.0/lab/workflow/sample/{sample}/result";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public UploadResultOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public UploadResultOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * POST /v1.0/lab/workflow/sample/{sample}/result
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI));
        }

        /**
         * POST /v1.0/lab/workflow/sample/{sample}/result
         * @return FileUpload
         */
        public FileUpload executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<FileUpload>(){}.getType();
            return execute(handler).as(type);
        }

         /**
         * @param body (UploadRequest) kit status (required)
         */
        public UploadResultOper body(UploadRequest body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * @param sample (String) sample (required)
         */
        public UploadResultOper samplePath(Object sample) {
            reqSpec.addPathParam("sample", sample);
            return this;
        }

        /**
         * Customise request specification
         */
        public UploadResultOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public UploadResultOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
}