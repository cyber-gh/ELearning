# TeachersGetApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTeachersParam**](TeachersGetApi.md#getTeachersParam) | **POST** /teacher/get | 


<a name="getTeachersParam"></a>
# **getTeachersParam**
> InlineResponse2002 getTeachersParam()



get teachers

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = TeachersGetApi()
try {
    val result : InlineResponse2002 = apiInstance.getTeachersParam()
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

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

