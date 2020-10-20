package com.example.intento5.Model

import com.example.intento5.Model.Pojos.SuperHeroes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface SuperHeroesApi {

    //Veja confiable
    @GET("/all.json")
    fun fetchAllSuperHeroes(): Call<List<SuperHeroes>>

    //Corrutinas
    @GET("/all.json")
    suspend fun fetchAllSuperHeroesWithCoroutines(): Response<List<SuperHeroes>>

}