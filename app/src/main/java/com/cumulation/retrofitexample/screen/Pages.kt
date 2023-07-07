package com.cumulation.retrofitexample.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.cumulation.retrofitexample.netwok.api.DataState
import com.cumulation.retrofitexample.netwok.model.Genres
import com.cumulation.retrofitexample.netwok.model.MovieTitles
import com.cumulation.retrofitexample.screen.componets.CardWithText
import com.cumulation.retrofitexample.screen.componets.CircularLoader
import com.cumulation.retrofitexample.screen.componets.HeaderText
import com.cumulation.retrofitexample.screen.componets.IndicatorWithErrorMessage
import com.cumulation.retrofitexample.viewmodel.RetrofitViewModel

@Composable
fun Pages(viewModel: RetrofitViewModel) {
    var genres = viewModel.genres.observeAsState(DataState.Init)
    var movieTitles = viewModel.movieTitle.observeAsState(DataState.Init)
    BackGround(){
        Column {
            LazyColumn(modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth()){
                item {
                    HeaderText(text="Genres")
                }
                when(genres.value){
                    is DataState.Init -> {
                        Log.d("Genres","Init")
                        item {
                            CircularLoader()
                        }
                    }
                    is DataState.Success -> {
                        val data = (genres.value as DataState.Success<Genres>).data.results;
                        Log.d("Genres","Success")
                        items(data.size) {index ->
                            CardWithText(data[index])
                        }
                    }
                    is DataState.Failure ->{
                        val msg =  (genres.value as DataState.Failure).errorMsg
                        Log.d("Genres","Failure")
                        item {
                            IndicatorWithErrorMessage(msg)
                        }
                    }
                }
            }
            LazyColumn(modifier = Modifier.fillMaxHeight().fillMaxWidth()){
                item {
                    HeaderText(text="Movie Title")
                }
                when(movieTitles.value){
                    is DataState.Init -> {
                        Log.d("Movie Title","Init")
                        item {
                            CircularLoader()
                        }
                    }
                    is DataState.Success -> {
                        Log.d("Movie Title","Success")
                        val data = (movieTitles.value as DataState.Success<MovieTitles>).data.results;
                        items(data.size) {index ->
                            CardWithText(data[index].titleText?.text)
                        }
                    }
                    is DataState.Failure ->{
                        Log.d("Movie Title","Failure")
                        val msg =  (movieTitles.value as DataState.Failure).errorMsg
                        item {
                            IndicatorWithErrorMessage(msg)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BackGround(content: @Composable () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), content = content)
}