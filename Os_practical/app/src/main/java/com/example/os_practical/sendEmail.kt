package com.example.os_practical

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class sendEmail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_email)

        var edreci=findViewById<EditText>(R.id.ed_recipient)
        var edSubject=findViewById<EditText>(R.id.ed_subject)
        var emailMsg=findViewById<EditText>(R.id.ed_emailMsg)

        var btn=findViewById<Button>(R.id.btn_sendEmail)
        btn.setOnClickListener {

            val intent=Intent(Intent.ACTION_SEND)

            intent.data= Uri.parse("mailto:")
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(edreci.text.toString()))
            intent.putExtra(Intent.EXTRA_SUBJECT,edSubject.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT,emailMsg.text.toString())
            startActivity(Intent.createChooser(intent,"Choose Email Account"))
        }

    }
}