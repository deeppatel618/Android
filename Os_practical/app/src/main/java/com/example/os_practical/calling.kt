package com.example.os_practical

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat

class calling : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling)
        var numb=findViewById<EditText>(R.id.ed_number)
        var call=findViewById<Button>(R.id.btn_call)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),1)

        call.setOnClickListener {
            var i=Intent(Intent.ACTION_CALL)
            i.data= Uri.parse("tel:"+numb.text.toString())

            startActivity(i)
        }
    }
}