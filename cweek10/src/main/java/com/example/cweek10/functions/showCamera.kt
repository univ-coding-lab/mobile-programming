package com.example.cweek10.functions

import android.content.Context
import android.content.Intent
import android.provider.MediaStore

fun showCamera(context: Context) {
    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    context.startActivity(cameraIntent)
}
