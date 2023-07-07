package com.cumulation.retrofitexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cumulation.retrofitexample.netwok.api.DataState
import com.cumulation.retrofitexample.netwok.api.NetworkResult
import com.cumulation.retrofitexample.netwok.api.convertToDataState
import com.cumulation.retrofitexample.netwok.model.Genres
import com.cumulation.retrofitexample.netwok.model.MovieTitles
import com.cumulation.retrofitexample.repo.NetworkRepositry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RetrofitViewModel @Inject constructor(
    private val repositry: NetworkRepositry
) : ViewModel() {
    private val _genres: MutableLiveData<DataState<Genres>> = MutableLiveData(DataState.Init)
    var genres: LiveData<DataState<Genres>> = _genres
    private val _movieTitle: MutableLiveData<DataState<MovieTitles>> =
        MutableLiveData(DataState.Init)
    var movieTitle: LiveData<DataState<MovieTitles>> = _movieTitle

    init {
//        getResultAResultB()
//        getGetResultAB()
        getPageAorPageB()
    }

    /**
     * Wait for resultA then get resultB
     */
    fun getResultAResultB() {
        viewModelScope.launch {
            _genres.postValue(DataState.Init)
            _movieTitle.postValue(DataState.Init)
            val resultA = async { repositry.getGenres() }
            _genres.postValue(resultA.await().convertToDataState())
            val resultB = async { repositry.getMovieTitles() }
            _movieTitle.postValue(resultB.await().convertToDataState())
        }
    }

    fun getGetResultAB() {
        viewModelScope.launch {
            _genres.postValue(DataState.Init)
            _movieTitle.postValue(DataState.Init)
            val resultA = async { repositry.getGenres() }
            val resultB = async { repositry.getMovieTitles() }
            val result = awaitAll(resultA, resultB)
            _genres.postValue(result[0].convertToDataState() as DataState<Genres>)
            _movieTitle.postValue(result[1].convertToDataState() as DataState<MovieTitles>)
        }
    }

    fun getPageAorPageB() {
        viewModelScope.launch {
            _genres.postValue(DataState.Init)
            repositry.getGenres().let { result ->
                _genres.postValue(result.convertToDataState())
            }
        }
        viewModelScope.launch {
            _movieTitle.postValue(DataState.Init)
            repositry.getMovieTitles().let { result ->
                _movieTitle.postValue(result.convertToDataState())
            }
        }
    }
}