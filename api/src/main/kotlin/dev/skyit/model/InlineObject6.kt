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

import dev.skyit.model.Student

import com.squareup.moshi.Json
/**
 * 
 * @param data 
 * @param token 
 */

data class InlineObject6 (
    @Json(name = "data")
    val data: Student? = null,
    @Json(name = "token")
    val token: kotlin.String? = null
)
