# CoursesInsertApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**insertCoursesParam**](CoursesInsertApi.md#insertCoursesParam) | **POST** /courses/insert | 


<a name="insertCoursesParam"></a>
# **insertCoursesParam**
> InlineResponse2001 insertCoursesParam()



insert courses

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = CoursesInsertApi()
try {
    val result : InlineResponse2001 = apiInstance.insertCoursesParam()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CoursesInsertApi#insertCoursesParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CoursesInsertApi#insertCoursesParam")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

