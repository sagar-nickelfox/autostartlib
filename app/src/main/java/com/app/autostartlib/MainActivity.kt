package com.app.autostartlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.autostartlibrary.AutoStartDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AutoStartDialog.startPowerSaverIntent(this, "In order to sync contacts in backgrond you need to apply auto start permission in settings.")
    }
}
