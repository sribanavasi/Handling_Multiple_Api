package com.cumulation.retrofitexample.netwok.api

import android.util.Log
import com.cumulation.retrofitexample.netwok.ApiServices
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiRetrofit {
    var retrofitServ: ApiServices?

    init {
        retrofitServ = null
    }

    fun setUpBaseUrl() {
        try {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://moviesdatabase.p.rapidapi.com")
                .client(HttpClientWithIntercept.client)
                .build()
            retrofitServ = retrofit.create(ApiServices::class.java)
        } catch (e: Exception) {
            Log.d("exception", "$e")
        }
    }
}

object HttpClientWithIntercept {
    val client: OkHttpClient

    init {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(HeaderInterceptor)
            .build();
    }
}

object HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val modifiedRequest = originalRequest.newBuilder()
            .header("X-RapidAPI-Key", "71c648bc0cmshe9ddfd78997b89ep179d2cjsn8d1411198a4f")
            .header("X-RapidAPI-Host", "moviesdatabase.p.rapidapi.com")
            .build()

        return chain.proceed(modifiedRequest)
    }
}