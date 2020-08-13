# StepsApi

All URIs are relative to *https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteSteps**](StepsApi.md#deleteSteps) | **DELETE** /v1.0/step_log | Delete all step logs


<a name="deleteSteps"></a>
# **deleteSteps**
> deleteSteps(body)

Delete all step logs

Delete step logs

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

StepsApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).steps();

api.deleteSteps()
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StepReset**](StepReset.md)| service account |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

