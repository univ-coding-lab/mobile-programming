package com.example.homework2.model

data class ImageItem(
    val image: ImageUri,
    val label: String,
    val checked: Boolean,
    val onCheckedChange: (Boolean) -> Unit
)
