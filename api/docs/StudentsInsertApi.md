# StudentsInsertApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**insertStudentsParam**](StudentsInsertApi.md#insertStudentsParam) | **POST** /students/insert | 


<a name="insertStudentsParam"></a>
# **insertStudentsParam**
> InlineResponse2001 insertStudentsParam(body)



insert students

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = StudentsInsertApi()
val body : InlineObject5 =  // InlineObject5 | 
try {
    val result : InlineResponse2001 = apiInstance.insertStudentsParam(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling StudentsInsertApi#insertStudentsParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling StudentsInsertApi#insertStudentsParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject5**](InlineObject5.md)|  | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
