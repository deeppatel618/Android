package com.example.apicalling

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_register=findViewById<Button>(R.id.btn_register)
        var username=findViewById<EditText>(R.id.ed_username)
        var email=findViewById<EditText>(R.id.ed_email)
        var password=findViewById<EditText>(R.id.ed_password)
        var subject=findViewById<EditText>(R.id.ed_subject)

        btn_register.setOnClickListener {
            Toast.makeText(this, ""+username.text.toString()+","+email.text.toString()+","+password.text.toString()+","+subject.text.toString(), Toast.LENGTH_SHORT).show()
            var retrofit = Retrofit.Builder().baseUrl("https://peermeeting.000webhostapp.com/").addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
            var result = retrofit.registerStudent(username.text.toString(),email.text.toString(),password.text.toString(),subject.text.toString())

            result.enqueue(object:Callback<List<studentData>?>{
                override fun onResponse(
                    call: Call<List<studentData>?>,
                    response: Response<List<studentData>?>
                ) {
                    Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<List<studentData>?>, t: Throwable) {
//                    Toast.makeText(applicationContext, "!Error! "+ t.toString() , Toast.LENGTH_LONG).show()
                }

            })

        }
        var btn_haveAccount=findViewById<MaterialButton>(R.id.btn_haveAccount)
        btn_haveAccount.setOnClickListener{
            var intent= Intent(MainActivity@this,login::class.java)
            startActivity(intent)
        }
    }
}