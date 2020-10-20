package com.example.intento5.Model.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.intento5.Model.Local.Room.SuperHeroesDao

import com.example.intento5.Model.Local.Room.SuperHeroesDatabase
import com.example.intento5.Model.Local.Room.SuperHeroesEntity
import com.example.intento5.Model.Network.Retrofit.SuperHeroesRepository

class SuperHeroesViewModel(application: Application) :AndroidViewModel(application) {
    private val mRepository : SuperHeroesRepository
    val liveDataFromLocal: LiveData<List<SuperHeroesEntity>>

    init {
        val superHeroesDao = SuperHeroesDatabase.getDatabase(application).superHeroesDao()
        mRepository = SuperHeroesRepository(superHeroesDao)
        mRepository.getDataFromServer()
        liveDataFromLocal = mRepository.allSuperHeroesLiveData
    }

}