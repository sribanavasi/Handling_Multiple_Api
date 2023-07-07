package com.cumulation.retrofitexample.netwok

import com.cumulation.retrofitexample.netwok.model.Genres
import com.cumulation.retrofitexample.netwok.model.MovieTitles
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("/titles/utils/genres")
    suspend fun getGenres(): Response<Genres>

    @GET("/titles")
    suspend fun getMovieTitles(
        @Query("genre") genre: String?,
        @Query("page") page: Int?
    ): Response<MovieTitles>
}