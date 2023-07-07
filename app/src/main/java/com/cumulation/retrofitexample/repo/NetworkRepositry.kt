package com.cumulation.retrofitexample.repo

import com.cumulation.retrofitexample.netwok.ApiServices
import com.cumulation.retrofitexample.netwok.api.ApiHandler
import com.cumulation.retrofitexample.netwok.api.NetworkResult
import com.cumulation.retrofitexample.netwok.model.Genres
import com.cumulation.retrofitexample.netwok.model.MovieTitles
import javax.inject.Inject

interface NetworkRepositry {
    suspend fun getGenres(): NetworkResult<Genres>
    suspend fun getMovieTitles(genre: String? = null, page: Int? = null): NetworkResult<MovieTitles>
}

class NetworkRepositryImp @Inject constructor(
    private val apiServices: ApiServices
) : NetworkRepositry,ApiHandler {

    //Another way of init the Retrofi
//    init {
//        ApiRetrofit.setUpBaseUrl()
//    }
//
//    suspend fun getGenres(): NetworkResult<Genres> =
//        handleApi { ApiRetrofit.retrofitServ!!.getGenres() }
//
//    suspend fun getMovieTitles(
//        genre: String? = null,
//        page: Int? = null
//    ): NetworkResult<MovieTitles> =
//        handleApi { ApiRetrofit.retrofitServ!!.getMovieTitles(genre = genre, page = page) }

    override suspend fun getGenres(): NetworkResult<Genres> = handleApi { apiServices.getGenres() }

    override suspend fun getMovieTitles(genre: String?, page: Int?): NetworkResult<MovieTitles> = handleApi { apiServices.getMovieTitles(genre = genre, page = page) }

}