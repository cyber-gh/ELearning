/**
* awesome.
* Documentation of our awesome API.
*
* The version of the OpenAPI document: 1.0.0
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package dev.skyit.model

import dev.skyit.model.Session

import com.squareup.moshi.Json
/**
 * 
 * @param student 
 */

data class InlineResponse2002 (
    @Json(name = "student")
    val student: kotlin.Array<Session>? = null
)

