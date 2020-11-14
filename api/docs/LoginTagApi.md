# LoginTagApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**loginParam**](LoginTagApi.md#loginParam) | **POST** /login | Login into application.


<a name="loginParam"></a>
# **loginParam**
> Session loginParam(body)

Login into application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = LoginTagApi()
val body : UserAuth =  // UserAuth | 
try {
    val result : Session = apiInstance.loginParam(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling LoginTagApi#loginParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling LoginTagApi#loginParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserAuth**](UserAuth.md)|  | [optional]

### Return type

[**Session**](Session.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

