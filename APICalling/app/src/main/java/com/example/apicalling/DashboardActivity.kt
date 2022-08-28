package com.example.apicalling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://jsonplaceholder.typicode.com/"
class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var rev_data=findViewById<RecyclerView>(R.id.rv)
        rev_data.layoutManager =GridLayoutManager(DashboardActivity@this,2)
        var retrofit=Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        var result= retrofit.getallPhotos()
        result.enqueue(object :Callback<List<photoData>?>{
            override fun onResponse(
                call: Call<List<photoData>?>,
                response: Response<List<photoData>?>
            ) {
               var photodataItem:ArrayList<photoData> = ArrayList();
                photodataItem=(response.body() as ArrayList<photoData> /* = java.util.ArrayList<com.example.apicalling.photoData> */)
                var myadapter=photoAdapter(applicationContext,photodataItem)
                rev_data.adapter=myadapter
            }

            override fun onFailure(call: Call<List<photoData>?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}