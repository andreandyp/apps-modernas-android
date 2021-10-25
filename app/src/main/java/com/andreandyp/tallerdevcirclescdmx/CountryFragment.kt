package com.andreandyp.tallerdevcirclescdmx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.andreandyp.tallerdevcirclescdmx.data.CountriesRepository
import com.andreandyp.tallerdevcirclescdmx.data.DataResult
import com.andreandyp.tallerdevcirclescdmx.databinding.FragmentCountryBinding
import com.andreandyp.tallerdevcirclescdmx.network.CountriesAPI
import com.andreandyp.tallerdevcirclescdmx.network.RetrofitCountriesDataSource
import com.andreandyp.tallerdevcirclescdmx.viewmodels.CountryViewModel
import com.andreandyp.tallerdevcirclescdmx.viewmodels.CountryViewModelFactory

/**
 * A fragment representing a list of Items.
 */
class CountryFragment : Fragment() {
    private lateinit var binding: FragmentCountryBinding
    private lateinit var adapter: CountryAdapter
    private lateinit var imageLoader: ImageLoader
    private val countriesService = CountriesAPI.countriesService
    private val retrofitCountriesDataSource = RetrofitCountriesDataSource(countriesService)
    private val countriesRepository = CountriesRepository(retrofitCountriesDataSource)
    private val countryViewModel by viewModels<CountryViewModel> { createViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageLoader = ImageLoader.Builder(requireContext())
            .componentRegistry {
                add(SvgDecoder(requireContext()))
            }
            .build()

        setupRecyclerView()

        countryViewModel.countries.observe(viewLifecycleOwner) {
            adapter.values = it!!
            adapter.notifyDataSetChanged()
        }
        countryViewModel.status.observe(viewLifecycleOwner) {
            when (it) {
                is DataResult.Loading -> {
                    binding.countriesSwipeRefresh.isRefreshing = true
                }
                is DataResult.DataSuccess -> {
                    binding.countriesSwipeRefresh.isRefreshing = false
                    binding.noInternetTextView.isVisible = false
                }
                is DataResult.DataError -> {
                    binding.countriesSwipeRefresh.isRefreshing = false
                    binding.noInternetTextView.isVisible = true
                }
            }
        }

        binding.countriesSwipeRefresh.setOnRefreshListener { countryViewModel.fetchCountries(true) }
    }

    private fun setupRecyclerView() {
        adapter = CountryAdapter(imageLoader, emptyList())
        binding.countriesRecyclerView.adapter = adapter
    }

    private fun createViewModelFactory(): CountryViewModelFactory {
        return CountryViewModelFactory(countriesRepository)
    }
}