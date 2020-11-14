# org.openapitools.client - Kotlin client library for awesome.

## Requires

* Kotlin 1.3.41
* Gradle 4.9

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://http://192.168.1.156:9999*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*LoginTagApi* | [**loginParam**](docs/LoginTagApi.md#loginparam) | **POST** /login | Login into application.
*RegisterTagApi* | [**registerParam**](docs/RegisterTagApi.md#registerparam) | **POST** /register | Register to application.


<a name="documentation-for-models"></a>
## Documentation for Models

 - [dev.skyit.model.Session](docs/Session.md)
 - [dev.skyit.model.UserAuth](docs/UserAuth.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="basic"></a>
### basic

- **Type**: HTTP basic authentication

