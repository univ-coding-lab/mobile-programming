package com.example.homework2.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.homework2.model.ImageItem

@Composable
fun ItemWithCheckBox(item: ImageItem, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = item.checked,
            onCheckedChange = item.onCheckedChange
        )
        Text(text = item.label)
    }
}
