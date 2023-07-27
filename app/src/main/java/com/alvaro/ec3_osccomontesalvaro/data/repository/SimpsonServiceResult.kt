package com.alvaro.ec3_osccomontesalvaro.data.repository

sealed class SimpsonServiceResult<T>(data: T? =null, error: java.lang.Exception? =null) {

    data class Success<T>(val data: T): SimpsonServiceResult<T>(null)
    data class Error<T>(val error: Exception): SimpsonServiceResult<T>(null, error)

}