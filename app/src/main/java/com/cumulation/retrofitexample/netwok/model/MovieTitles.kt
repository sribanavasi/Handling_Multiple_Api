package com.cumulation.retrofitexample.netwok.model

import com.google.gson.annotations.SerializedName


data class MovieTitles (

    @SerializedName("page"    ) var page    : Int?               = null,
    @SerializedName("next"    ) var next    : String?            = null,
    @SerializedName("entries" ) var entries : Int?               = null,
    @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()

)

data class Caption (

    @SerializedName("plainText"  ) var plainText : String? = null,
    @SerializedName("__typename" ) var _typename : String? = null

)

data class PrimaryImage (

    @SerializedName("id"         ) var id        : String?  = null,
    @SerializedName("width"      ) var width     : Int?     = null,
    @SerializedName("height"     ) var height    : Int?     = null,
    @SerializedName("url"        ) var url       : String?  = null,
    @SerializedName("caption"    ) var caption   : Caption? = Caption(),
    @SerializedName("__typename" ) var _typename : String?  = null

)

data class TitleType (

    @SerializedName("text"       ) var text      : String?  = null,
    @SerializedName("id"         ) var id        : String?  = null,
    @SerializedName("isSeries"   ) var isSeries  : Boolean? = null,
    @SerializedName("isEpisode"  ) var isEpisode : Boolean? = null,
    @SerializedName("__typename" ) var _typename : String?  = null

)

data class TitleText (

    @SerializedName("text"       ) var text      : String? = null,
    @SerializedName("__typename" ) var _typename : String? = null

)

data class OriginalTitleText (

    @SerializedName("text"       ) var text      : String? = null,
    @SerializedName("__typename" ) var _typename : String? = null

)

data class ReleaseYear (

    @SerializedName("year"       ) var year      : Int?    = null,
    @SerializedName("endYear"    ) var endYear   : String? = null,
    @SerializedName("__typename" ) var _typename : String? = null

)

data class ReleaseDate (

    @SerializedName("day"        ) var day       : Int?    = null,
    @SerializedName("month"      ) var month     : Int?    = null,
    @SerializedName("year"       ) var year      : Int?    = null,
    @SerializedName("__typename" ) var _typename : String? = null

)


data class Results (
    @SerializedName("id"                ) var id                : String?            = null,
    @SerializedName("primaryImage"      ) var primaryImage      : PrimaryImage?      = PrimaryImage(),
    @SerializedName("titleType"         ) var titleType         : TitleType?         = TitleType(),
    @SerializedName("titleText"         ) var titleText         : TitleText?         = TitleText(),
    @SerializedName("originalTitleText" ) var originalTitleText : OriginalTitleText? = OriginalTitleText(),
    @SerializedName("releaseYear"       ) var releaseYear       : ReleaseYear?       = ReleaseYear(),
    @SerializedName("releaseDate"       ) var releaseDate       : ReleaseDate?       = ReleaseDate()

)
