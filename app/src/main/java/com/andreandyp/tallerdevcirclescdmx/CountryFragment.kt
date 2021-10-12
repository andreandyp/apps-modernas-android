package com.andreandyp.tallerdevcirclescdmx

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.andreandyp.tallerdevcirclescdmx.data.CountriesRepository
import com.andreandyp.tallerdevcirclescdmx.data.DataResult
import com.andreandyp.tallerdevcirclescdmx.databinding.FragmentCountryBinding
import com.andreandyp.tallerdevcirclescdmx.domain.Country
import com.andreandyp.tallerdevcirclescdmx.network.CountriesAPI
import com.andreandyp.tallerdevcirclescdmx.network.RetrofitCountriesDataSource
import com.andreandyp.tallerdevcirclescdmx.placeholder.PlaceholderContent
import kotlinx.coroutines.runBlocking

/**
 * A fragment representing a list of Items.
 */
class CountryFragment : Fragment() {
    private lateinit var binding: FragmentCountryBinding
    private val countriesService = CountriesAPI.countriesService
    private val retrofitCountriesDataSource = RetrofitCountriesDataSource(countriesService)
    private val countriesRepository = CountriesRepository(retrofitCountriesDataSource)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.countriesSwipeRefresh.isEnabled = false

        runBlocking {
            val result = countriesRepository.getAllCountries()
            if (result is DataResult.DataSuccess) {
                binding.countriesRecyclerView.adapter = CountryAdapter(result.data)
            } else {
                Toast.makeText(requireContext(), "Sucedió un error", Toast.LENGTH_LONG).show()
            }
        }
    }
}