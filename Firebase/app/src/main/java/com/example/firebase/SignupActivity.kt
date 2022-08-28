package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    lateinit var auth:FirebaseAuth//firebase
    lateinit var databaseReference:DatabaseReference//firebase

    lateinit var firebaseUser: FirebaseUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //firebase

        auth=FirebaseAuth.getInstance()

        //
        var edUsername=findViewById<EditText>(R.id.ed_username)
        var edEmail=findViewById<EditText>(R.id.ed_email)
        var edPassword=findViewById<EditText>(R.id.ed_password)
        var btnSave=findViewById<Button>(R.id.ed_btnsave)

        var login_page=findViewById<Button>(R.id.ed_login_page)

        firebaseUser=auth.currentUser!! //If user is already logged in

        if(firebaseUser!=null)
        {
            var i =Intent(SignupActivity@this,dashboard::class.java)
            finish()
            startActivity(i)
        }


        login_page.setOnClickListener {
            var intent= Intent(SignupActivity@this,LoginActivity::class.java)
            startActivity(intent)
        }
        btnSave.setOnClickListener {
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
            auth.createUserWithEmailAndPassword(edEmail.text.toString(),edPassword.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        var user:FirebaseUser?=auth.currentUser
                        var userId:String=user!!.uid

                        databaseReference=FirebaseDatabase.getInstance().reference.child(userId)

                        var hashMap:HashMap<String,String> = HashMap()
                        hashMap.put("userId",userId)
                        hashMap.put("username",edUsername.text.toString())
                        hashMap.put("profileImage","")

                        databaseReference.setValue(hashMap).addOnCompleteListener {
                            if(it.isSuccessful)
                            {
                                Toast.makeText(this, "data added", Toast.LENGTH_SHORT).show()
                            }
                            else
                            {
                                Toast.makeText(this, ""+it.exception!!.message, Toast.LENGTH_SHORT).show()
                            }
                        }

                    }
                    else
                    {
                        Toast.makeText(this, ""+it.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}