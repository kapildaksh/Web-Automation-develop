# FoodApi

All URIs are relative to *https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAllFoods**](FoodApi.md#addAllFoods) | **POST** /v1.0/food_log | Add food logs
[**deleteFoods**](FoodApi.md#deleteFoods) | **DELETE** /v1.0/food_log | Delete all food logs
[**updateFood**](FoodApi.md#updateFood) | **PATCH** /v1.0/food_log/{food_log_id} | Update a food log


<a name="addAllFoods"></a>
# **addAllFoods**
> addAllFoods(body)

Add food logs

Add food logs

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

FoodApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).food();

api.addAllFoods()
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FoodList**](FoodList.md)| food list |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteFoods"></a>
# **deleteFoods**
> deleteFoods(body)

Delete all food logs

Delete food logs

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

FoodApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).food();

api.deleteFoods()
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FoodReset**](FoodReset.md)| service account |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateFood"></a>
# **updateFood**
> updateFood(foodLogId, body)

Update a food log

Update a food log

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

FoodApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).food();

api.updateFood()
    .foodLogIdPath(foodLogId)
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **foodLogId** | **Integer**| Food Log Id |
 **body** | [**Food**](Food.md)| food log |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

