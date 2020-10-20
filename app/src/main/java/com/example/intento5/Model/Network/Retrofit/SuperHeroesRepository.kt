package com.example.intento5.Model.Network.Retrofit

import android.util.Log
import android.widget.Toast
import com.example.intento5.Model.Local.Room.SuperHeroesDao
import com.example.intento5.Model.Local.Room.SuperHeroesEntity
import com.example.intento5.Model.Network.Retrofit.RetrofitClient
import com.example.intento5.Model.Pojos.SuperHeroes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperHeroesRepository(private val superHeroesDao: SuperHeroesDao) {
    private val retroService = RetrofitClient.getRetrofitClient()

    // El metodo siguiente trae la tabla superHeroesEntity
    val allSuperHeroesLiveData = superHeroesDao.showAllSuperHeroes()

    // La vieja confiable
    fun getDataFromServer() {
        val call = retroService.fetchAllSuperHeroes()
        call.enqueue(object : Callback<List<SuperHeroes>> {
            override fun onResponse(
                call: Call<List<SuperHeroes>>,
                response: Response<List<SuperHeroes>>
            ) {
                when (response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            superHeroesDao.insertAllSuperHeroes(convert(it))
                        }
                    }
                    in 300..399 -> Log.d("Response", response.body().toString())
                    in 400..599 -> Log.d("Response", response.body().toString())
                    else -> Log.d("Error", response.body().toString())
                }
            }

            override fun onFailure(call: Call<List<SuperHeroes>>, t: Throwable) {
                Log.e("Error", t.message.toString())
                // TODO: 20/10/2020 escribir mensaje sin internet con un mlivedata
            }
        })
    }

    fun convert(listFromNetwork: List<SuperHeroes>): List<SuperHeroesEntity> {
        val listMutable = mutableListOf<SuperHeroesEntity>()

        listFromNetwork.map {
            listMutable.add(
                SuperHeroesEntity(
                    it.id,
                    it.images.xs,
                    it.images.lg,
                    it.name,
                    it.biography.alterEgos,
                    it.appearance.height
                )
            )
        }
        return listMutable
    }
}