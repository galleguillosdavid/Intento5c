package com.example.intento5.Model.Local.Room

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "super_heroes_table")
data class SuperHeroesEntity(
    @PrimaryKey
    @NonNull
    val id          : Int,
    val imageXs     : String,
    val imageLg     : String,
    val name        : String,
    val AlterEgos   : String?,
    @Embedded
    val height      : List<String>
)