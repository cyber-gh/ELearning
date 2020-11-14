# WorkspaceInsertApi

All URIs are relative to *http://192.168.1.156:9999*

Method | HTTP request | Description
------------- | ------------- | -------------
[**insertWorkspaceParam**](WorkspaceInsertApi.md#insertWorkspaceParam) | **POST** /workspaces/insert | 


<a name="insertWorkspaceParam"></a>
# **insertWorkspaceParam**
> insertWorkspaceParam(body)



insert workspaces

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import dev.skyit.model.*

val apiInstance = WorkspaceInsertApi()
val body : InlineObject8 =  // InlineObject8 | 
try {
    apiInstance.insertWorkspaceParam(body)
} catch (e: ClientException) {
    println("4xx response calling WorkspaceInsertApi#insertWorkspaceParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WorkspaceInsertApi#insertWorkspaceParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**InlineObject8**](InlineObject8.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

