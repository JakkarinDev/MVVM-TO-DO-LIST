package com.example.mvvmtodolistapp.retrofit

import com.example.mvvmtodolistapp.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
//    @GET("services")
//    fun getServices() : Call<ServicesSetterGetter>

    @GET("todos/1")
    fun getServices() : Call<ServicesSetterGetter>

    @GET("todos/")
    fun getAllServices() : Call<List<ServicesSetterGetter>>
}