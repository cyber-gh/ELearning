# CategoriesInsertApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**insertCategoriesParam**](CategoriesInsertApi.md#insertCategoriesParam) | **POST** /categories/insert | 


<a name="insertCategoriesParam"></a>
# **insertCategoriesParam**
> InlineResponse200 insertCategoriesParam(body)



insert categories

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = CategoriesInsertApi()
val body : InlineObject1 =  // InlineObject1 | 
try {
    val result : InlineResponse200 = apiInstance.insertCategoriesParam(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesInsertApi#insertCategoriesParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesInsertApi#insertCategoriesParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject1**](InlineObject1.md)|  | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

