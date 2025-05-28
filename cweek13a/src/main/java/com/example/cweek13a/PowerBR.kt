package com.example.cweek13a

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PowerBR : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_POWER_CONNECTED) {
            Toast.makeText(context, "전원 연결", Toast.LENGTH_SHORT).show()
        } else if (intent?.action == Intent.ACTION_POWER_DISCONNECTED) {
            Toast.makeText(context, "전원 연결 해제", Toast.LENGTH_SHORT).show()
        }
    }
}
