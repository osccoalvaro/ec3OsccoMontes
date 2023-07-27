package com.alvaro.ec3_osccomontesalvaro.data.retrofit

import com.alvaro.ec3_osccomontesalvaro.data.response.ListSimpsonResponse
import retrofit2.http.GET

interface SimpsonService {

    @GET("personajes?limit=20")
    suspend fun getAllNotes(): ListSimpsonResponse

}