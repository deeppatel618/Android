package com.example.apicalling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btn_login=findViewById<MaterialButton>(R.id.btn_login)
        var email=findViewById<EditText>(R.id.ed_email_login)
        var password=findViewById<EditText>(R.id.ed_password_login)

        btn_login.setOnClickListener {
            Toast.makeText(this, ""+email.text.toString()+","+password.text.toString(), Toast.LENGTH_SHORT).show()
            var retrofit = Retrofit.Builder().baseUrl("https://mananapp.000webhostapp.com/").addConverterFactory(
                GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
            var result = retrofit.login(email.text.toString(),password.text.toString())

            result.enqueue(object: Callback<List<studentData>?> {
                override fun onResponse(
                    call: Call<List<studentData>?>,
                    response: Response<List<studentData>?>
                ) {
//                    Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()

                    var responseBody=response.body()
                    for(data in responseBody!!)
                    {
                        Log.d("mydata","welcome - "+data.name)
                    }
                }

                override fun onFailure(call: Call<List<studentData>?>, t: Throwable) {
//                    Toast.makeText(applicationContext, "!Error! "+ t.toString() , Toast.LENGTH_LONG).show()
                }

            })

        }

    }
}