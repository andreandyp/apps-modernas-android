package com.andreandyp.tallerdevcirclescdmx.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreandyp.tallerdevcirclescdmx.data.CountriesRepository
import com.andreandyp.tallerdevcirclescdmx.data.DataResult
import com.andreandyp.tallerdevcirclescdmx.domain.Country
import kotlinx.coroutines.launch

class CountryViewModel(
    private val countriesRepository: CountriesRepository
) : ViewModel() {
    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _status = MutableLiveData<DataResult<List<Country>>>()
    val status: LiveData<DataResult<List<Country>>> = _status

    init {
        fetchCountries()
    }

    fun fetchCountries(forceUpdate: Boolean = false) {
        _status.value = DataResult.Loading
        viewModelScope.launch {
            val result = countriesRepository.getAllCountries(forceUpdate)
            if (result is DataResult.DataSuccess) {
                _countries.value = result.data!!
            }  else {
                _countries.value = emptyList()
            }

            _status.value = result
        }
    }
}