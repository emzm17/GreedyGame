package com.example.greedygame.api

import com.example.greedygame.constants.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

     private val retrofit= Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build()

     val api= retrofit.create(RetrofitServices::class.java)
}