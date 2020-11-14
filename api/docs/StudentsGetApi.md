# StudentsGetApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStudentsParam**](StudentsGetApi.md#getStudentsParam) | **POST** /students/get | 


<a name="getStudentsParam"></a>
# **getStudentsParam**
> InlineResponse2002 getStudentsParam(body)



get students

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = StudentsGetApi()
val body : InlineObject6 =  // InlineObject6 | 
try {
    val result : InlineResponse2002 = apiInstance.getStudentsParam(body)
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
 **body** | [**InlineObject6**](InlineObject6.md)|  | [optional]

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

