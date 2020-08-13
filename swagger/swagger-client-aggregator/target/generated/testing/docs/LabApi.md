# LabApi

All URIs are relative to *https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBarcode**](LabApi.md#createBarcode) | **POST** /v1.0/barcode/provider/{provider} | Generate a new kit barcode
[**getBarcode**](LabApi.md#getBarcode) | **GET** /v1.0/barcode/provider/{provider} | Get an available kit barcode
[**updateKitStatus**](LabApi.md#updateKitStatus) | **PUT** /v1.0/customer/account/{account}/track_kit | Update kit status
[**updateKitStatusServiceAccount**](LabApi.md#updateKitStatusServiceAccount) | **PUT** /v1.0/customer/serviceaccount/{serviceaccount}/track_kit | Update kit status
[**updateProductKitStatus**](LabApi.md#updateProductKitStatus) | **PATCH** /v1.0/customer/account/{account}/track_kit | Update kit status (product)
[**updateProductKitStatusServiceAccount**](LabApi.md#updateProductKitStatusServiceAccount) | **PATCH** /v1.0/customer/serviceaccount/{serviceaccount}/track_kit | Update kit status (product)


<a name="createBarcode"></a>
# **createBarcode**
> BarcodeModel createBarcode(provider)

Generate a new kit barcode

Generate a new kit barcode

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

LabApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).lab();

api.createBarcode()
    .providerPath(provider).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **provider** | **String**| Kit provider |

### Return type

[**BarcodeModel**](BarcodeModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getBarcode"></a>
# **getBarcode**
> BarcodeModel getBarcode(provider)

Get an available kit barcode

Get an available kit barcode

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

LabApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).lab();

api.getBarcode()
    .providerPath(provider).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **provider** | **String**| Kit provider |

### Return type

[**BarcodeModel**](BarcodeModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateKitStatus"></a>
# **updateKitStatus**
> updateKitStatus(account, body)

Update kit status

Update kit status

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

LabApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).lab();

api.updateKitStatus()
    .accountPath(account)
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **account** | **String**| account |
 **body** | [**TrackKitRequest**](TrackKitRequest.md)| kit status |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateKitStatusServiceAccount"></a>
# **updateKitStatusServiceAccount**
> updateKitStatusServiceAccount(serviceaccount, body)

Update kit status

Update kit status

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

LabApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).lab();

api.updateKitStatusServiceAccount()
    .serviceaccountPath(serviceaccount)
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **serviceaccount** | **String**| service account |
 **body** | [**TrackKitRequest**](TrackKitRequest.md)| kit status |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateProductKitStatus"></a>
# **updateProductKitStatus**
> updateProductKitStatus(account, body)

Update kit status (product)

Update kit status (product)

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

LabApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).lab();

api.updateProductKitStatus()
    .accountPath(account)
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **account** | **String**| account |
 **body** | [**TrackKitsRequest**](TrackKitsRequest.md)| kit status |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateProductKitStatusServiceAccount"></a>
# **updateProductKitStatusServiceAccount**
> updateProductKitStatusServiceAccount(serviceaccount, body)

Update kit status (product)

Update kit status (product)

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

LabApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).lab();

api.updateProductKitStatusServiceAccount()
    .serviceaccountPath(serviceaccount)
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **serviceaccount** | **String**| service account |
 **body** | [**TrackKitsRequest**](TrackKitsRequest.md)| kit status |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

