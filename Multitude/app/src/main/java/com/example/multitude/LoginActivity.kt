package com.example.multitude

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        var ed_signup_username=findViewById<EditText>(R.id.ed_signup_username)
        var ed_signup_email=findViewById<EditText>(R.id.ed_signup_email)
        var ed_signup_name=findViewById<EditText>(R.id.ed_signup_name)
        var ed_signup_password=findViewById<EditText>(R.id.ed_signup_password)
        var btn_signup=findViewById<MaterialButton>(R.id.btn_signup)

        btn_signup.setOnClickListener {

        }

    }
}