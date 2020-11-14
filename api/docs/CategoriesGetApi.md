# CategoriesGetApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCategoriesParam**](CategoriesGetApi.md#getCategoriesParam) | **POST** /categories/get | 


<a name="getCategoriesParam"></a>
# **getCategoriesParam**
> InlineResponse200 getCategoriesParam(body)



get categories

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = CategoriesGetApi()
val body : InlineObject =  // InlineObject | 
try {
    val result : InlineResponse200 = apiInstance.getCategoriesParam(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesGetApi#getCategoriesParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesGetApi#getCategoriesParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject**](InlineObject.md)|  | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

