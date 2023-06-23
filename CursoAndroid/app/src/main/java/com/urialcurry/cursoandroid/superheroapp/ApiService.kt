package com.urialcurry.cursoandroid.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/10232437574184230/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String):Response<superHeroDataResponse>

    @GET("/api/10232437574184230/{id}")
    suspend fun getSuperheroDetail(@Path("id") supeheroId:String):Response<SuperHeroDetailResponse>
}