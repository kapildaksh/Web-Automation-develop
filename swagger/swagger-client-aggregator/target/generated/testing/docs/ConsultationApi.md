# ConsultationApi

All URIs are relative to *https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**updateConsultation**](ConsultationApi.md#updateConsultation) | **PATCH** /v1.0/customer/account/{account}/consultation | Update consultation


<a name="updateConsultation"></a>
# **updateConsultation**
> updateConsultation(account, body)

Update consultation

Update consultation

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

ConsultationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).consultation();

api.updateConsultation()
    .accountPath(account)
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **account** | **String**| account |
 **body** | [**ConsultationRequest**](ConsultationRequest.md)| consultation |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

