package com.example.os_practical

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class InternetConnectivityCheck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet_connectivity_check)
        var check=findViewById<Button>(R.id.btn_check)
        check.setOnClickListener {

            if(checkInternet(this) )
            {
                Toast.makeText(this, "Internet to haiii", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "Internet to nahiii haii", Toast.LENGTH_SHORT).show()

            }

        }


    }
    fun checkInternet(context:Context):Boolean
    {
        var connectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            var network = connectivityManager.activeNetwork?:return false
            var activenetwork= connectivityManager.getNetworkCapabilities(network)?:return false

            return when{
                activenetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ->true
                activenetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ->true
                else ->false
            }

        }
        else
        {
            val networkInfo =connectivityManager.activeNetworkInfo?:return false
            return networkInfo.isConnected
        }

    }
}