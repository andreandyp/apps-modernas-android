package com.andreandyp.tallerdevcirclescdmx.network

import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesService {
    @GET("all")
    suspend fun getAllCountries(): List<CountryNetwork>

    @GET("alpha/{code}")
    suspend fun getCountryByCode(@Path("code") code: String): CountryNetwork
}