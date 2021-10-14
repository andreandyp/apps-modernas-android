package com.andreandyp.tallerdevcirclescdmx.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object CountriesAPI {
    private const val BASE_URL = "https://restcountries.com/v2/"

    private val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    val countriesService: CountriesService by lazy {
        retrofit.create(CountriesService::class.java)
    }
}