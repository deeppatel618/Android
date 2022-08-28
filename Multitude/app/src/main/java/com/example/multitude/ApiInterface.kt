package com.example.multitude


import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @FormUrlEncoded
    @POST("register.php")
    fun registerUser(@Field("username")username:String
                     ,@Field("email")email:String,
                     @Field("name")name:String,
                     @Field("password") password:String
    )
}