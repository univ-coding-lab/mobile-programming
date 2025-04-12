package com.example.homework2.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.homework2.R
import com.example.homework2.model.ImageItem
import com.example.homework2.model.ImageUri

@Composable
fun MainScreen() {
    var showArms by rememberSaveable { mutableStateOf(false) }
    var showEyes by rememberSaveable { mutableStateOf(true) }
    var showEars by rememberSaveable { mutableStateOf(false) }
    var showEyebrows by rememberSaveable { mutableStateOf(false) }
    var showGlasses by rememberSaveable { mutableStateOf(true) }
    var showHat by rememberSaveable { mutableStateOf(true) }
    var showMouth by rememberSaveable { mutableStateOf(false) }
    var showMustache by rememberSaveable { mutableStateOf(false) }
    var showNose by rememberSaveable { mutableStateOf(true) }
    var showShoes by rememberSaveable { mutableStateOf(false) }

    val imageItems = listOf(
        ImageItem(ImageUri.ResImage(R.drawable.arms), "Arms", showArms) { showArms = it },
        ImageItem(ImageUri.ResImage(R.drawable.eyes), "Eyes", showEyes) { showEyes = it },
        ImageItem(ImageUri.ResImage(R.drawable.ears), "Ears", showEars) { showEars = it },
        ImageItem(ImageUri.ResImage(R.drawable.eyebrows), "Eyebrows", showEyebrows) { showEyebrows = it },
        ImageItem(ImageUri.ResImage(R.drawable.glasses), "Glasses", showGlasses) { showGlasses = it },
        ImageItem(ImageUri.ResImage(R.drawable.hat), "Hat", showHat) { showHat = it },
        ImageItem(ImageUri.ResImage(R.drawable.mouth), "Mouth", showMouth) { showMouth = it },
        ImageItem(ImageUri.ResImage(R.drawable.mustache), "Mustache", showMustache) { showMustache = it },
        ImageItem(ImageUri.ResImage(R.drawable.nose), "Nose", showNose) { showNose = it },
        ImageItem(ImageUri.ResImage(R.drawable.shoes), "Shoes", showShoes) { showShoes = it },
    )
    Text(text = "\n202012308 오상훈")

    val orientation = LocalConfiguration.current.orientation

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(model = R.drawable.body, contentDescription = "Body")
                imageItems.forEach { item ->
                    val img = when(item.image) {
                        is ImageUri.ResImage -> item.image.resID
                        is ImageUri.WebImage -> item.image.webUrl
                    }
                    if (item.checked) AsyncImage(
                        model = img,
                        contentDescription = item.label
                    )
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {
                TwoColumnCheckboxes(items = imageItems)
            }
        }
    } else {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(model = R.drawable.body, contentDescription = "Body")
                imageItems.forEach { item ->
                    val img = when(item.image) {
                        is ImageUri.ResImage -> item.image.resID
                        is ImageUri.WebImage -> item.image.webUrl
                    }
                    if (item.checked) AsyncImage(
                        model = img,
                        contentDescription = item.label
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                TwoColumnCheckboxes(items = imageItems)
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
