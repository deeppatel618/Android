package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var btn:Button

    lateinit var auth: FirebaseAuth
    lateinit var firebaseUser: FirebaseUser


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email=findViewById<EditText>(R.id.ed_login_email)
        password=findViewById<EditText>(R.id.ed_login_password)
        btn=findViewById<Button>(R.id.ed_login)

        auth = FirebaseAuth.getInstance()

        btn.setOnClickListener {
            auth.signInWithEmailAndPassword(email.text.toString(),password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()
                        var i =Intent(LoginActivity@this,dashboard::class.java)
                        startActivity(i)
                    }
                    else
                    {
                        Toast.makeText(this, "Details incorrect", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}