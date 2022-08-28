package com.example.os_practical

import android.annotation.SuppressLint
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate

class sensor : AppCompatActivity(),SensorEventListener {
    lateinit var sensorManager: SensorManager
    var brightness:Sensor?=null
    lateinit var maincontainer:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_sensor)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        sensorManager=getSystemService(SENSOR_SERVICE) as SensorManager
        brightness = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        maincontainer=findViewById<LinearLayout>(R.id.maincontainer)
        sensorManager.registerListener(this,brightness,SensorManager.SENSOR_DELAY_NORMAL)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type == Sensor.TYPE_LIGHT)
        {
            val light1= event.values[0]
            Log.d("mydata" , "sensor : "+ light1 )
            mybrightness(light1)

        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Log.d("mydata","acc = "+accuracy)
        return
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    fun mybrightness(brightness:Float)
    {
        when(brightness.toInt())
        {
            0->Log.d("bright","data 1")
            in 1..10->Log.d("bright","data 2")
            in 11..50->Log.d("bright","data 3")
            in 51..500->Log.d("bright","data 4")
            else->"extra light"
        }
    }
}