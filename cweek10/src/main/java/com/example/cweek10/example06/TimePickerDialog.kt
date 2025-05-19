package com.example.cweek10.example06

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun TimePickerDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(text = "취소")
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text(text = "확인")
            }
        },
        text = { content() }
    )
}

