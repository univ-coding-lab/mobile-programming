package com.example.cweek10.example02

import android.Manifest
import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.cweek10.example01.MainScreen01
import com.example.cweek10.functions.makeCall
import com.example.cweek10.uicomponents.RationaleDialog
import com.example.cweek10.uicomponents.SettingsDialog
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen02(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val callPermissionState = rememberPermissionState(permission = Manifest.permission.CALL_PHONE)
    var showCallDialog by remember { mutableStateOf(false) }
    var showSettingDialog by remember { mutableStateOf(false) }
    var permissionConfirm by remember { mutableStateOf(false) }

    fun requestCallPermission() {
        when {
            callPermissionState.status.isGranted -> {
                makeCall(context)
            }

            callPermissionState.status.shouldShowRationale -> {
                showCallDialog = true
            }

            else -> {
                if (permissionConfirm)
                    showSettingDialog = true
                else {
                    permissionConfirm = true
                    callPermissionState.launchPermissionRequest()
                }
            }
        }
    }

    if (showCallDialog) {
        RationaleDialog(
            onDismiss = { showCallDialog = false },
            onConfirm = {
                showCallDialog = false
                callPermissionState.launchPermissionRequest()
            }
        )
    }

    if (showSettingDialog) {
        SettingsDialog(
            onDismiss = { showSettingDialog = false },
            onGoToSettings = {
                showSettingDialog = false
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = "package:${context.packageName}".toUri()
                }
                context.startActivity(intent)
            }
        )
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Button(onClick = {
//            val web = Uri.parse("https://www.naver.com")
//            val webIntent = Intent(Intent.ACTION_VIEW, web)
            val webIntent = Intent(Intent.ACTION_VIEW).apply {
                data = "https://www.naver.com".toUri()
            }
            context.startActivity(webIntent)

        }, modifier = Modifier.width(200.dp)) {
            Text("네이버")
        }

        Button(onClick = {
            val location = "geo:37.543684,127.077130?z=16".toUri()
            val mapIntent = Intent(Intent.ACTION_VIEW, location)
            context.startActivity(mapIntent)
        }, modifier = Modifier.width(200.dp)) {
            Text("맵")
        }

        Button(onClick = {
            val message = "sms:010-1234-1234".toUri()
            val messageIntent = Intent(Intent.ACTION_SENDTO, message)
            messageIntent.putExtra("sms_body", "집에 가자....")
            context.startActivity(messageIntent)
        }, modifier = Modifier.width(200.dp)) {
            Text("문자보내기")
        }

        Button(onClick = {
//            val number = "tel:010-1234-1234".toUri()
//            val callIntent = Intent(Intent.ACTION_DIAL, number)
//            context.startActivity(callIntent)
        }, modifier = Modifier.width(200.dp)) {
            Text("전화걸기")
        }

//        Button(onClick = {
//            val number = Uri.parse("tel:010-1234-1234")
//            val callIntent = Intent(Intent.ACTION_CALL, number)
//            context.startActivity(callIntent)
//        }, modifier = Modifier.width(200.dp)) {
//            Text("전화걸기")
//        }
    }
}

@Preview
@Composable
private fun MainScreen01Preview() {
    MainScreen02()
}
