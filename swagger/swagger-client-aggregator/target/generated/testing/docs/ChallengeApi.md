# ChallengeApi

All URIs are relative to *https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getChallenge**](ChallengeApi.md#getChallenge) | **GET** /v1.0/challenge/serviceaccount/{serviceaccount}/type/{type} | Get a challenge
[**getChallenges**](ChallengeApi.md#getChallenges) | **GET** /v1.0/challenge/serviceaccount/{serviceaccount} | Get all challenges
[**resetChallenge**](ChallengeApi.md#resetChallenge) | **POST** /v1.0/challenge_reset | Reset challenge
[**updateChallenge**](ChallengeApi.md#updateChallenge) | **PATCH** /v1.0/challenge/account/{account} | Update challenge


<a name="getChallenge"></a>
# **getChallenge**
> Challenge getChallenge(serviceaccount, type)

Get a challenge

Get a challenge

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

ChallengeApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).challenge();

api.getChallenge()
    .serviceaccountPath(serviceaccount)
    .typePath(type).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **serviceaccount** | **String**| Service account |
 **type** | **String**| challenge type | [enum: steps_challenge, meals_challenge, sleeps_challenge]

### Return type

[**Challenge**](Challenge.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getChallenges"></a>
# **getChallenges**
> ChallengeList getChallenges(serviceaccount)

Get all challenges

Get all challenges

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

ChallengeApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).challenge();

api.getChallenges()
    .serviceaccountPath(serviceaccount).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **serviceaccount** | **String**| Service account |

### Return type

[**ChallengeList**](ChallengeList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="resetChallenge"></a>
# **resetChallenge**
> resetChallenge(body)

Reset challenge

Reset challenge

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

ChallengeApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).challenge();

api.resetChallenge()
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ChallengeReset**](ChallengeReset.md)| service account detail |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateChallenge"></a>
# **updateChallenge**
> updateChallenge(account, body)

Update challenge

Update challenge

### Example
```java
// Import classes:
//import com.prenetics.swagger.testing.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

ChallengeApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("https://virtserver.swaggerhub.com/PreneticsPlatform/genie-public-api-gateway/1.0.0"))).challenge();

api.updateChallenge()
    .accountPath(account)
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **account** | **String**| account/email |
 **body** | [**ChallengeList**](ChallengeList.md)| challenge list |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

