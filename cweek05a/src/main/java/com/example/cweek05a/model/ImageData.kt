package com.example.cweek05a.model

data class ImageData(
    val image: ImageUri,
    val buttonType: ButtonType,
    val likes: Int = 0,
    val dislikes: Int = 0
)
