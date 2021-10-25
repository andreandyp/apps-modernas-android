package com.andreandyp.tallerdevcirclescdmx.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andreandyp.tallerdevcirclescdmx.data.CountriesRepository

@Suppress("UNCHECKED_CAST")
class CountryViewModelFactory(
    private val countriesRepository: CountriesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryViewModel(countriesRepository) as T
    }
}