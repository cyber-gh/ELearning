# FoobarTagApi

All URIs are relative to *http://some-url.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**idOfFoobarEndpoint**](FoobarTagApi.md#idOfFoobarEndpoint) | **POST** /foobar | Foobar does some amazing stuff.


<a name="idOfFoobarEndpoint"></a>
# **idOfFoobarEndpoint**
> FooBarResponse idOfFoobarEndpoint(body)

Foobar does some amazing stuff.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = FoobarTagApi()
val body : FooBarRequest =  // FooBarRequest | This text will appear as description of your request body.
try {
    val result : FooBarResponse = apiInstance.idOfFoobarEndpoint(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FoobarTagApi#idOfFoobarEndpoint")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FoobarTagApi#idOfFoobarEndpoint")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FooBarRequest**](FooBarRequest.md)| This text will appear as description of your request body. | [optional]

### Return type

[**FooBarResponse**](FooBarResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

