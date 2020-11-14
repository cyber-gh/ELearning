# TeachersGetApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTeachersParam**](TeachersGetApi.md#getTeachersParam) | **POST** /teacher/get | 


<a name="getTeachersParam"></a>
# **getTeachersParam**
> kotlin.Array&lt;Teacher&gt; getTeachersParam()



get teachers

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = TeachersGetApi()
try {
    val result : kotlin.Array<Teacher> = apiInstance.getTeachersParam()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TeachersGetApi#getTeachersParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TeachersGetApi#getTeachersParam")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;Teacher&gt;**](Teacher.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

