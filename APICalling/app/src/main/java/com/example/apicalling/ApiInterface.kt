package com.example.apicalling

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @FormUrlEncoded
    @POST("register.php")
    fun registerStudent(@Field("name") name: String,
                        @Field("email") email: String,
                        @Field("password") password: String,
                        @Field("subject") subject: String,
    ):retrofit2.Call<List<studentData>>

    @GET("login.php")
    fun login(@Query("email") email:String,@Query("password") password: String):Call<List<studentData>>

    @GET("photos")
    fun getallPhotos(): Call<List<photoData>>
}