package com.example.os_practical

import android.Manifest
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.getSystemService

class Wakelock : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wakelock)
        var start =findViewById<Button>(R.id.btn_startWakeLock)
        var stop = findViewById<Button>(R.id.btn_stopWakeLock)

        var wakelock:PowerManager.WakeLock?=null
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WAKE_LOCK),1)
        start.setOnClickListener {
            wakelock=(getSystemService(Context.POWER_SERVICE) as PowerManager).run {
                newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"Myapp:wakeLock").apply {
                    acquire()
                }
            }
//            Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show()
        }
        stop.setOnClickListener {
            if(wakelock!!.isHeld)
            {
                wakelock!!.release()
                Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show()
            }


        }
    }
}