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


import com.squareup.moshi.Json
/**
 * 
 * @param feedback 
 * @param name 
 * @param rating 
 * @param studentId 
 */

data class Review (
    @Json(name = "feedback")
    val feedback: kotlin.String? = null,
    @Json(name = "name")
    val name: kotlin.String? = null,
    @Json(name = "rating")
    val rating: kotlin.Int? = null,
    @Json(name = "student_id")
    val studentId: kotlin.String? = null
)

