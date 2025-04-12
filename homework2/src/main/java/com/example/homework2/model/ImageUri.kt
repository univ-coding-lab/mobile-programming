package com.example.homework2.model

sealed class ImageUri {
    data class ResImage(val resID: Int) : ImageUri()
    data class WebImage(val webUrl: String) : ImageUri()
}
