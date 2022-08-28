package com.example.os_practical

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_start=findViewById<Button>(R.id.btn_start)
        var btn_stop=findViewById<Button>(R.id.btn_stop)



        btn_start.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // can also use `Settings.Panel.ACTION_WIFI` to enable/disable only WiFi
                val panelIntent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
                startActivityForResult(panelIntent, 0)
            } else {
                // use previous solution, add appropriate permissions to AndroidManifest file (see answers above)
                (this.applicationContext?.getSystemService(Context.WIFI_SERVICE) as? WifiManager)?.apply { isWifiEnabled = true /*or false*/ }
            }
        }

    }
}