package com.cumulation.retrofitexample.netwok.api

import retrofit2.HttpException
import retrofit2.Response

interface ApiHandler {
    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        return try {
            val response = execute()
            //Log.d("response","$response")
            val body = response.body()
            //Log.d("response","$body")
            if (response.isSuccessful && body != null) {
                NetworkResult.Success(response.code(), body)
            } else {
                NetworkResult.Error(code = response.code(), errorMsg = response.errorBody().toString())
            }
        }catch (e:HttpException){
            NetworkResult.Error(e.code(),e.message())
        }catch (e:Throwable){
            NetworkResult.Exception(e)
        }

    }
}