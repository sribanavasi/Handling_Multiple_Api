package com.cumulation.retrofitexample.netwok.model

import com.google.gson.annotations.SerializedName


data class Genres (

    @SerializedName("results" ) var results : ArrayList<String> = arrayListOf()

)