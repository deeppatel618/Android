package com.example.os_practical

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat

class sms : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)
        var ed_msg=findViewById<EditText>(R.id.ed_msg)
        var ed_num=findViewById<EditText>(R.id.ed_num)

        var send=findViewById<Button>(R.id.btn_msg)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS),1)
        send.setOnClickListener {
            var num=ed_num.text.toString()
            var msg=ed_msg.text.toString()
            val smsmanager:SmsManager=SmsManager.getDefault()
            smsmanager.sendTextMessage(num,null,msg,null,null);
            Toast.makeText(this, "Msg sended = "+msg, Toast.LENGTH_SHORT).show()
        }
    }
}