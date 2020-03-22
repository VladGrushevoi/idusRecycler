package com.vladgrushevoy.testindus.models

import com.squareup.moshi.Json
import java.io.Serializable

data class Artist(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
    @Json(name = "picture")
    val picture_url: String
) : Serializable
