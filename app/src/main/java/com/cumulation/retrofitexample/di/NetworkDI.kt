package com.cumulation.retrofitexample.di

import com.cumulation.retrofitexample.netwok.ApiServices
import com.cumulation.retrofitexample.netwok.api.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkDI {

    @Singleton
    @Provides
    fun provideBaseUrl():String = "https://moviesdatabase.p.rapidapi.com";

    @Singleton
    @Provides
    fun interpt(): Interceptor {
        return HeaderInterceptor
    }

    @Singleton
    @Provides
    fun provideHttpClient(intercept:Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(intercept)
            .build();
    }

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }
}