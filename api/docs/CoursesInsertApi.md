# CoursesInsertApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**insertCoursesParam**](CoursesInsertApi.md#insertCoursesParam) | **POST** /courses/insert | 


<a name="insertCoursesParam"></a>
# **insertCoursesParam**
> insertCoursesParam()



insert courses

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = CoursesInsertApi()
try {
    apiInstance.insertCoursesParam()
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

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

