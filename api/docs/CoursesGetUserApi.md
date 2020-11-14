# CoursesGetUserApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**coursesGetUserParam**](CoursesGetUserApi.md#coursesGetUserParam) | **POST** /courses/get/user | 


<a name="coursesGetUserParam"></a>
# **coursesGetUserParam**
> InlineResponse2001 coursesGetUserParam(body)



courses get user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = CoursesGetUserApi()
val body : InlineObject3 =  // InlineObject3 | 
try {
    val result : InlineResponse2001 = apiInstance.coursesGetUserParam(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CoursesGetUserApi#coursesGetUserParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CoursesGetUserApi#coursesGetUserParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject3**](InlineObject3.md)|  | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

