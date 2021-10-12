package com.andreandyp.tallerdevcirclescdmx.network

import com.andreandyp.tallerdevcirclescdmx.domain.Country

class RetrofitCountriesDataSource(
    private val countriesService: CountriesService
) {
    suspend fun getAllCountries(): List<Country> {
        return countriesService.getAllCountries().map { it.asDomain() }
    }

    suspend fun getCountryByCode(code: String): Country {
        return countriesService.getCountryByCode(code).asDomain()
    }
}