package com.urialcurry.cursoandroid.superheroapp

import com.google.gson.annotations.SerializedName

data class superHeroDataResponse(@SerializedName ("response") val response:String,
                                   @SerializedName("results") val superheroes: List<superHeroItemResponse>)

data class superHeroItemResponse(
    @SerializedName("id") val superheroId:String,
    @SerializedName("name") val superheroName:String,
    @SerializedName("image") val superheroImage:superHeroImageResponse
)

data class superHeroImageResponse(
    @SerializedName("url") val url:String
)