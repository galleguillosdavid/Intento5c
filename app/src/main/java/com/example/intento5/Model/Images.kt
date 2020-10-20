package com.example.intento5.Model


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("lg")
    val lg: String,
    @SerializedName("md")
    val md: String,
    @SerializedName("sm")
    val sm: String,
    @SerializedName("xs")
    val xs: String
)