package com.example.applearningandroid.data.model

import java.io.Serializable

data class Topic(
    var id: Int,
    var name: String,
    val content: String
): Serializable
