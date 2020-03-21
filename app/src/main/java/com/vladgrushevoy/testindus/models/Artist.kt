package com.vladgrushevoy.testindus.models

import java.io.Serializable

data class Artist(
    val id: Long,
    val name: String,
    val picture_url: String
) : Serializable
