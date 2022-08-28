package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class dashboard : AppCompatActivity() {

    lateinit var recyclerview:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerview=findViewById(R.id.rec_view)
        recyclerview.layoutManager = LinearLayoutManager(dashboard@this,androidx.recyclerview.widget.RecyclerView.VERTICAL,false)

    }
}