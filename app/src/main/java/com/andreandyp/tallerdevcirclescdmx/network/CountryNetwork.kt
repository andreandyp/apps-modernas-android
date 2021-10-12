package com.andreandyp.tallerdevcirclescdmx.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryNetwork(
    @Json(name = "name")
    val name: String,
    @Json(name = "capital")
    val capital: String?,
    @Json(name = "population")
    val population: String,
    @Json(name = "area")
    val area: String?,
    @Json(name = "flag")
    val flag: String,
    @Json(name = "alpha2Code")
    val alpha2Code: String,
    @Json(name = "alpha3Code")
    val alpha3Code: String,
)