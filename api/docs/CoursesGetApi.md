# CoursesGetApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCoursesParam**](CoursesGetApi.md#getCoursesParam) | **POST** /courses/get | 


<a name="getCoursesParam"></a>
# **getCoursesParam**
> kotlin.Array&lt;Course&gt; getCoursesParam(body)



get courses

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = CoursesGetApi()
val body : InlineObject2 =  // InlineObject2 | 
try {
    val result : kotlin.Array<Course> = apiInstance.getCoursesParam(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CoursesGetApi#getCoursesParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CoursesGetApi#getCoursesParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject2**](InlineObject2.md)|  | [optional]

### Return type

[**kotlin.Array&lt;Course&gt;**](Course.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

