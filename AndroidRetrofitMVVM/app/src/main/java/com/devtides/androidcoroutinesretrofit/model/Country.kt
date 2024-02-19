package com.devtides.androidcoroutinesretrofit.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("Name")
    val countryName: String?,

    @SerializedName("capital")
    val capital: String?,

    @SerializedName("flagPNG")
    val flag: String?
)