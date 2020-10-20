package com.example.intento5.Model.Local.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperHeroesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllSuperHeroes(mList :List<SuperHeroesEntity>)

   @Query("SELECT * FROM super_heroes_table")
   fun showAllSuperHeroes(): LiveData<List<SuperHeroesEntity>>

    @Query("SELECT * FROM super_heroes_table WHERE id=:mId LIMIT 1")
    fun showOwnHeroesById(mId:Int): LiveData<SuperHeroesEntity>
}