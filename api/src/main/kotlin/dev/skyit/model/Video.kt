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
 * @param subtitles 
 * @param url 
 */

data class Video (
    @Json(name = "subtitles")
    val subtitles: kotlin.String? = null,
    @Json(name = "url")
    val url: kotlin.String? = null
)

