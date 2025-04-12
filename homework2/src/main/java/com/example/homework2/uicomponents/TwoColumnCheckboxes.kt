package com.example.homework2.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.homework2.model.ImageItem

@Composable
fun TwoColumnCheckboxes(items: List<ImageItem>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column {
            for (i in 0 until items.size / 2) {
                ItemWithCheckBox(items[i])
            }
        }
        Column {
            for (i in items.size / 2 until items.size) {
                ItemWithCheckBox(items[i])
            }
        }
    }
}
