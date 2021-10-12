package com.andreandyp.tallerdevcirclescdmx.data

import com.andreandyp.tallerdevcirclescdmx.domain.Country
import com.andreandyp.tallerdevcirclescdmx.network.RetrofitCountriesDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class CountriesRepository(
    private val retrofitCountriesDataSource: RetrofitCountriesDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private suspend fun getAllCountriesFromRemote() = withContext(dispatcher) {
        try {
            val result = retrofitCountriesDataSource.getAllCountries()
            DataResult.DataSuccess(result)
        } catch (e: IOException) {
            DataResult.DataError(e)
        }
    }

    private suspend fun getCountryByCodeFromRemote(code: String) = withContext(dispatcher) {
        try {
            val result = retrofitCountriesDataSource.getCountryByCode(code)
            DataResult.DataSuccess(result)
        } catch (e: IOException) {
            DataResult.DataError(e)
        }
    }

    suspend fun getAllCountries(forceUpdate: Boolean = false): DataResult<List<Country>> {
        return getAllCountriesFromRemote()
    }

    suspend fun getCountryByCode(code: String, forceUpdate: Boolean = false): DataResult<Country> {
        return getCountryByCodeFromRemote(code)
    }
}