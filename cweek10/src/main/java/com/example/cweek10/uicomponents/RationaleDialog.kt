package com.example.cweek10.uicomponents

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RationaleDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("권한 확인요청") },
        text = { Text("CALL_PHONE과 CAMERA 권한이 승인되어야 합니다.") },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text("권한승인")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("취소")
            }
        }
    )
}
