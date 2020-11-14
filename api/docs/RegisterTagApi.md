# RegisterTagApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**registerParam**](RegisterTagApi.md#registerParam) | **POST** /register | Register to application.


<a name="registerParam"></a>
# **registerParam**
> Session registerParam(body)

Register to application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = RegisterTagApi()
val body : UserAuth =  // UserAuth | 
try {
    val result : Session = apiInstance.registerParam(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RegisterTagApi#registerParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RegisterTagApi#registerParam")
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

