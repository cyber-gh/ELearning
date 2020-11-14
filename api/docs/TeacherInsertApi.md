# TeacherInsertApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**insertTeachersParam**](TeacherInsertApi.md#insertTeachersParam) | **POST** /teacher/insert | 


<a name="insertTeachersParam"></a>
# **insertTeachersParam**
> InlineResponse2001 insertTeachersParam(body)



insert teacher

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = TeacherInsertApi()
val body : InlineObject6 =  // InlineObject6 | 
try {
    val result : InlineResponse2001 = apiInstance.insertTeachersParam(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TeacherInsertApi#insertTeachersParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TeacherInsertApi#insertTeachersParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject6**](InlineObject6.md)|  | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

