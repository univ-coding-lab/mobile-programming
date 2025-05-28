package com.example.cweek13a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cweek13a.ui.theme.MobileprogrammingTheme

class MainActivity : ComponentActivity() {
//    val br = PowerBR()
//    override fun onStart() {
//        super.onStart()
//        val intentFilter = IntentFilter(Intent.ACTION_POWER_CONNECTED)
//        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
//        this.registerReceiver(br, intentFilter)
//    }
//
//    override fun onStop() {
//        this.unregisterReceiver(br)
//        super.onStop()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            MobileprogrammingTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileprogrammingTheme {
        Greeting("Android")
    }
}
