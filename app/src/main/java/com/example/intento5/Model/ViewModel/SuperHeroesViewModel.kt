package com.example.intento5.Model.ViewModel

import androidx.lifecycle.ViewModel
import com.example.intento5.Model.Network.Retrofit.SuperHeroesRepository

class SuperHeroesViewModel :ViewModel() {
    private val mRepository : SuperHeroesRepository

    init {
        mRepository = SuperHeroesRepository()
    }
}