package com.alvaro.ec3_osccomontesalvaro.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl("https://apisimpsons.fly.dev/api/").addConverterFactory(
            GsonConverterFactory.create()).build()
    val simpsonService: SimpsonService = retrofit.create(SimpsonService::class.java)

}
// https://apisimpsons.fly.dev/api/personajes