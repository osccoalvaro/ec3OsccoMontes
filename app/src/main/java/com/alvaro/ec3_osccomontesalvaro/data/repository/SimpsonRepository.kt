package com.alvaro.ec3_osccomontesalvaro.data.repository

import com.alvaro.ec3_osccomontesalvaro.data.response.ListSimpsonResponse
import com.alvaro.ec3_osccomontesalvaro.data.retrofit.RetrofitHelper

class SimpsonRepository {

    suspend fun getNotes(): SimpsonServiceResult<ListSimpsonResponse> {
        return try {
            val response = RetrofitHelper.simpsonService.getAllNotes()
            SimpsonServiceResult.Success(response)
        } catch (e: java.lang.Exception) {
            SimpsonServiceResult.Error(e)
        }
    }

}