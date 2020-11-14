# WorkspaceGetApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getWorkspaceParam**](WorkspaceGetApi.md#getWorkspaceParam) | **POST** /workspaces/get | 


<a name="getWorkspaceParam"></a>
# **getWorkspaceParam**
> InlineResponse2003 getWorkspaceParam(body)



get workspaces

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = WorkspaceGetApi()
val body : InlineObject7 =  // InlineObject7 | 
try {
    val result : InlineResponse2003 = apiInstance.getWorkspaceParam(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WorkspaceGetApi#getWorkspaceParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WorkspaceGetApi#getWorkspaceParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject7**](InlineObject7.md)|  | [optional]

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

