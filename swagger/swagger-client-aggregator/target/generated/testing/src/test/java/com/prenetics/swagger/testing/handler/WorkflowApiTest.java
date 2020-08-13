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

import java.math.BigDecimal;
import com.prenetics.swagger.testing.model.ErrorResponse;
import com.prenetics.swagger.testing.model.ExtractedSample;
import com.prenetics.swagger.testing.model.FileUpload;
import com.prenetics.swagger.testing.model.LabWorkflowStates;
import com.prenetics.swagger.testing.model.PrimarySample;
import com.prenetics.swagger.testing.model.Samples;
import com.prenetics.swagger.testing.model.TestRequest;
import com.prenetics.swagger.testing.model.UploadRequest;
import com.prenetics.swagger.testing.invoker.ApiClient;
import com.prenetics.swagger.testing.handler.WorkflowApi;
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
 * API tests for WorkflowApi
 */
@Ignore
public class WorkflowApiTest {

    private WorkflowApi api;

    @Before
    public void createApi() {
        api = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder().setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).workflow();
    }

    /**
     * Sample created
     */
    @Test
    public void shouldSee201AfterCreateSample() {
        String barcode = null;
        api.createSample()
                .barcodePath(barcode).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterCreateSample() {
        String barcode = null;
        api.createSample()
                .barcodePath(barcode).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterCreateSample() {
        String barcode = null;
        api.createSample()
                .barcodePath(barcode).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * Sample extracted
     */
    @Test
    public void shouldSee201AfterCreateTestData() {
        TestRequest body = null;
        api.createTestData()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterCreateTestData() {
        TestRequest body = null;
        api.createTestData()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterCreateTestData() {
        TestRequest body = null;
        api.createTestData()
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * Sample extracted
     */
    @Test
    public void shouldSee201AfterExtractSample() {
        String barcode = null;
        String sample = null;
        api.extractSample()
                .barcodePath(barcode)
                .samplePath(sample).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterExtractSample() {
        String barcode = null;
        String sample = null;
        api.extractSample()
                .barcodePath(barcode)
                .samplePath(sample).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterExtractSample() {
        String barcode = null;
        String sample = null;
        api.extractSample()
                .barcodePath(barcode)
                .samplePath(sample).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * All lab workflow states
     */
    @Test
    public void shouldSee200AfterGetLabWorkflowStates() {
        api.getLabWorkflowStates().execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterGetLabWorkflowStates() {
        api.getLabWorkflowStates().execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterGetLabWorkflowStates() {
        api.getLabWorkflowStates().execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * Sample marked
     */
    @Test
    public void shouldSee204AfterPrintSample() {
        String barcode = null;
        String sample = null;
        api.printSample()
                .barcodePath(barcode)
                .samplePath(sample).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterPrintSample() {
        String barcode = null;
        String sample = null;
        api.printSample()
                .barcodePath(barcode)
                .samplePath(sample).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterPrintSample() {
        String barcode = null;
        String sample = null;
        api.printSample()
                .barcodePath(barcode)
                .samplePath(sample).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * Customer lab workflow state reset
     */
    @Test
    public void shouldSee204AfterResetLabWorkflow() {
        BigDecimal customerId = null;
        api.resetLabWorkflow()
                .customerIdPath(customerId).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterResetLabWorkflow() {
        BigDecimal customerId = null;
        api.resetLabWorkflow()
                .customerIdPath(customerId).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterResetLabWorkflow() {
        BigDecimal customerId = null;
        api.resetLabWorkflow()
                .customerIdPath(customerId).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * Pending tasks removed
     */
    @Test
    public void shouldSee204AfterRetryLastLabWorkflow() {
        BigDecimal customerId = null;
        api.retryLastLabWorkflow()
                .customerIdPath(customerId).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterRetryLastLabWorkflow() {
        BigDecimal customerId = null;
        api.retryLastLabWorkflow()
                .customerIdPath(customerId).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterRetryLastLabWorkflow() {
        BigDecimal customerId = null;
        api.retryLastLabWorkflow()
                .customerIdPath(customerId).execute(r -> r.prettyPeek());
        // TODO: test validations
    }


    /**
     * Result uploaded
     */
    @Test
    public void shouldSee201AfterUploadResult() {
        String sample = null;
        UploadRequest body = null;
        api.uploadResult()
                .samplePath(sample)
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Bad request,  response message shows error details
     */
    @Test
    public void shouldSee400AfterUploadResult() {
        String sample = null;
        UploadRequest body = null;
        api.uploadResult()
                .samplePath(sample)
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * Internal server error
     */
    @Test
    public void shouldSee500AfterUploadResult() {
        String sample = null;
        UploadRequest body = null;
        api.uploadResult()
                .samplePath(sample)
                .body(body).execute(r -> r.prettyPeek());
        // TODO: test validations
    }

}