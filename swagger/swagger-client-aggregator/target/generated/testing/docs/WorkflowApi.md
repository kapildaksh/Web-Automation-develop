# WorkflowApi

All URIs are relative to *https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSample**](WorkflowApi.md#createSample) | **POST** /v1.0/lab/workflow/kit/{barcode}/sample | Create sample
[**createTestData**](WorkflowApi.md#createTestData) | **POST** /v1.0/lab/workflow/test_data | Create test data up to genotype upload
[**extractSample**](WorkflowApi.md#extractSample) | **POST** /v1.0/lab/workflow/kit/{barcode}/sample/{sample}/extraction | Extract sample
[**getLabWorkflowStates**](WorkflowApi.md#getLabWorkflowStates) | **GET** /v1.0/lab/workflow/available_states | Get lab workflow states
[**printSample**](WorkflowApi.md#printSample) | **PUT** /v1.0/lab/workflow/kit/{barcode}/sample/{sample}/print | Mark sample details printed
[**resetLabWorkflow**](WorkflowApi.md#resetLabWorkflow) | **DELETE** /v1.0/lab/workflow/customer/{customer_id}/reset | Reset customer lab workflow state
[**retryLastLabWorkflow**](WorkflowApi.md#retryLastLabWorkflow) | **DELETE** /v1.0/lab/workflow/customer/{customer_id}/retry | Remove pending tasks
[**uploadResult**](WorkflowApi.md#uploadResult) | **POST** /v1.0/lab/workflow/sample/{sample}/result | Upload test result


<a name="createSample"></a>
# **createSample**
> PrimarySample createSample(barcode)

Create sample

Create sample

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

WorkflowApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).workflow();

api.createSample()
    .barcodePath(barcode).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **barcode** | **String**| barcode |

### Return type

[**PrimarySample**](PrimarySample.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="createTestData"></a>
# **createTestData**
> Samples createTestData(body)

Create test data up to genotype upload

Create test data up to genotype upload

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

WorkflowApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).workflow();

api.createTestData()
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TestRequest**](TestRequest.md)| body |

### Return type

[**Samples**](Samples.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="extractSample"></a>
# **extractSample**
> ExtractedSample extractSample(barcode, sample)

Extract sample

Extract sample

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

WorkflowApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).workflow();

api.extractSample()
    .barcodePath(barcode)
    .samplePath(sample).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **barcode** | **String**| barcode |
 **sample** | **String**| sample |

### Return type

[**ExtractedSample**](ExtractedSample.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getLabWorkflowStates"></a>
# **getLabWorkflowStates**
> LabWorkflowStates getLabWorkflowStates()

Get lab workflow states

Get lab workflow states

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

WorkflowApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).workflow();

api.getLabWorkflowStates().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**LabWorkflowStates**](LabWorkflowStates.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="printSample"></a>
# **printSample**
> printSample(barcode, sample)

Mark sample details printed

Mark sample details printed

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

WorkflowApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).workflow();

api.printSample()
    .barcodePath(barcode)
    .samplePath(sample).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **barcode** | **String**| barcode |
 **sample** | **String**| sample |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="resetLabWorkflow"></a>
# **resetLabWorkflow**
> resetLabWorkflow(customerId)

Reset customer lab workflow state

Reset customer lab workflow state

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

WorkflowApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).workflow();

api.resetLabWorkflow()
    .customerIdPath(customerId).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customerId** | **BigDecimal**| customer_id |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="retryLastLabWorkflow"></a>
# **retryLastLabWorkflow**
> retryLastLabWorkflow(customerId)

Remove pending tasks

Remove pending tasks

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

WorkflowApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).workflow();

api.retryLastLabWorkflow()
    .customerIdPath(customerId).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customerId** | **BigDecimal**| customer_id |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="uploadResult"></a>
# **uploadResult**
> FileUpload uploadResult(sample, body)

Upload test result

Upload test result

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

WorkflowApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).workflow();

api.uploadResult()
    .samplePath(sample)
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sample** | **String**| sample |
 **body** | [**UploadRequest**](UploadRequest.md)| kit status |

### Return type

[**FileUpload**](FileUpload.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

