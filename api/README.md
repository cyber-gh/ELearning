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

All URIs are relative to *http://192.168.1.156:9999*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*CategoriesGetApi* | [**getCategoriesParam**](docs/CategoriesGetApi.md#getcategoriesparam) | **POST** /categories/get | 
*CategoriesInsertApi* | [**insertCategoriesParam**](docs/CategoriesInsertApi.md#insertcategoriesparam) | **POST** /categories/insert | 
*CoursesGetApi* | [**getCoursesParam**](docs/CoursesGetApi.md#getcoursesparam) | **POST** /courses/get | 
*CoursesInsertApi* | [**insertCoursesParam**](docs/CoursesInsertApi.md#insertcoursesparam) | **POST** /courses/insert | 
*CoursesJoinApi* | [**joinCoursesParam**](docs/CoursesJoinApi.md#joincoursesparam) | **POST** /courses/join | 
*LoginTagApi* | [**loginParam**](docs/LoginTagApi.md#loginparam) | **POST** /login | Login into application.
*RegisterTagApi* | [**registerParam**](docs/RegisterTagApi.md#registerparam) | **POST** /register | Register to application.
*StudentsGetApi* | [**getStudentsParam**](docs/StudentsGetApi.md#getstudentsparam) | **POST** /students/get | 
*StudentsInsertApi* | [**insertStudentsParam**](docs/StudentsInsertApi.md#insertstudentsparam) | **POST** /students/insert | 
*TeacherInsertApi* | [**insertTeachersParam**](docs/TeacherInsertApi.md#insertteachersparam) | **POST** /teacher/insert | 
*TeachersGetApi* | [**getTeachersParam**](docs/TeachersGetApi.md#getteachersparam) | **POST** /teacher/get | 
*WorkspaceGetApi* | [**getWorkspaceParam**](docs/WorkspaceGetApi.md#getworkspaceparam) | **POST** /workspaces/get | 
*WorkspaceInsertApi* | [**insertWorkspaceParam**](docs/WorkspaceInsertApi.md#insertworkspaceparam) | **POST** /workspaces/insert | 


<a name="documentation-for-models"></a>
## Documentation for Models

 - [dev.skyit.model.Category](docs/Category.md)
 - [dev.skyit.model.Course](docs/Course.md)
 - [dev.skyit.model.CoursesGetData](docs/CoursesGetData.md)
 - [dev.skyit.model.InlineObject](docs/InlineObject.md)
 - [dev.skyit.model.InlineObject1](docs/InlineObject1.md)
 - [dev.skyit.model.InlineObject2](docs/InlineObject2.md)
 - [dev.skyit.model.InlineObject3](docs/InlineObject3.md)
 - [dev.skyit.model.InlineObject4](docs/InlineObject4.md)
 - [dev.skyit.model.InlineObject5](docs/InlineObject5.md)
 - [dev.skyit.model.InlineObject6](docs/InlineObject6.md)
 - [dev.skyit.model.InlineObject7](docs/InlineObject7.md)
 - [dev.skyit.model.InlineObject8](docs/InlineObject8.md)
 - [dev.skyit.model.InlineResponse200](docs/InlineResponse200.md)
 - [dev.skyit.model.InlineResponse2001](docs/InlineResponse2001.md)
 - [dev.skyit.model.InlineResponse2002](docs/InlineResponse2002.md)
 - [dev.skyit.model.InlineResponse2003](docs/InlineResponse2003.md)
 - [dev.skyit.model.Lesson](docs/Lesson.md)
 - [dev.skyit.model.Review](docs/Review.md)
 - [dev.skyit.model.Session](docs/Session.md)
 - [dev.skyit.model.Student](docs/Student.md)
 - [dev.skyit.model.UserAuth](docs/UserAuth.md)
 - [dev.skyit.model.Video](docs/Video.md)
 - [dev.skyit.model.Workspace](docs/Workspace.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="basic"></a>
### basic

- **Type**: HTTP basic authentication

