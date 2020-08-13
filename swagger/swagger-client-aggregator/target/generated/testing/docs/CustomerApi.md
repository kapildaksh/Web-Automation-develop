# CustomerApi

All URIs are relative to *https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteCustomer**](CustomerApi.md#deleteCustomer) | **DELETE** /v1.0/customer/account/{account} | Delete a customer
[**getAvailableAccount**](CustomerApi.md#getAvailableAccount) | **GET** /v1.0/customer/available_account | Get an available account name


<a name="deleteCustomer"></a>
# **deleteCustomer**
> deleteCustomer(account)

Delete a customer

Delete a customer

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

CustomerApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).customer();

api.deleteCustomer()
    .accountPath(account).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **account** | **String**| account |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAvailableAccount"></a>
# **getAvailableAccount**
> AccountModel getAvailableAccount()

Get an available account name

Get an available account name

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

CustomerApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).customer();

api.getAvailableAccount().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AccountModel**](AccountModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

