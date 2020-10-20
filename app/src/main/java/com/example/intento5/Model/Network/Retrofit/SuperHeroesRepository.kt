package com.example.intento5.Model.Network.Retrofit

import android.util.Log
import android.widget.Toast
import com.example.intento5.Model.Network.Retrofit.RetrofitClient
import com.example.intento5.Model.Pojos.SuperHeroes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperHeroesRepository() {
    private val retroService = RetrofitClient.getRetrofitClient()

    // La vieja confiable
    fun getDataFromServer(){
        val call = retroService.fetchAllSuperHeroes()
        call.enqueue(object : Callback<List<SuperHeroes>> {
            override fun onResponse(
                call: Call<List<SuperHeroes>>,
                response: Response<List<SuperHeroes>>
            ) {
                when (response.code()) {
                    in 200..299 -> Log.d("Response",response.body().toString())
                    in 300..399 -> Log.d("Response",response.body().toString())
                    in 400..599 -> Log.d("Response",response.body().toString())
                    else -> Log.d("Error",response.body().toString())
                }
            }

            override fun onFailure(call: Call<List<SuperHeroes>>, t: Throwable) {
                Log.e("Error", t.message.toString())
                // TODO: 20/10/2020 escribir mensaje sin internet con un mlivedata
            }
        })
    }
}