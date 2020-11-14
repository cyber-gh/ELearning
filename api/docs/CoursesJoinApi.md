# CoursesJoinApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**joinCoursesParam**](CoursesJoinApi.md#joinCoursesParam) | **POST** /courses/join | 


<a name="joinCoursesParam"></a>
# **joinCoursesParam**
> joinCoursesParam(body)



join courses

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = CoursesJoinApi()
val body : InlineObject3 =  // InlineObject3 | 
try {
    apiInstance.joinCoursesParam(body)
} catch (e: ClientException) {
    println("4xx response calling CoursesJoinApi#joinCoursesParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CoursesJoinApi#joinCoursesParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject3**](InlineObject3.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

