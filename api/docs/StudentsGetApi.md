# StudentsGetApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStudentsParam**](StudentsGetApi.md#getStudentsParam) | **POST** /students/get | 


<a name="getStudentsParam"></a>
# **getStudentsParam**
> kotlin.Array&lt;Student&gt; getStudentsParam(body)



get students

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = StudentsGetApi()
val body : InlineObject4 =  // InlineObject4 | 
try {
    val result : kotlin.Array<Student> = apiInstance.getStudentsParam(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling StudentsGetApi#getStudentsParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling StudentsGetApi#getStudentsParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject4**](InlineObject4.md)|  | [optional]

### Return type

[**kotlin.Array&lt;Student&gt;**](Student.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

