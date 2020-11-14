# ReviewsAddApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addReviewParam**](ReviewsAddApi.md#addReviewParam) | **POST** /reviews/add | 


<a name="addReviewParam"></a>
# **addReviewParam**
> addReviewParam(body)



add review

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = ReviewsAddApi()
val body : InlineObject5 =  // InlineObject5 | 
try {
    apiInstance.addReviewParam(body)
} catch (e: ClientException) {
    println("4xx response calling ReviewsAddApi#addReviewParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReviewsAddApi#addReviewParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject5**](InlineObject5.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

