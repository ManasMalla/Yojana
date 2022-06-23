package com.manasmalla.yojana.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.manasmalla.yojana.YojanaApplication

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Setting the window to fill screen
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val application = (application as YojanaApplication)

        setContent {
            YojanaApp(yojanaApplication = application)
        }
    }
}
