package com.andreandyp.tallerdevcirclescdmx

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andreandyp.tallerdevcirclescdmx.databinding.FragmentCountryBinding
import com.andreandyp.tallerdevcirclescdmx.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class CountryFragment : Fragment() {
    private lateinit var binding: FragmentCountryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.countriesRecyclerView.adapter = CountryAdapter(PlaceholderContent.ITEMS)
        binding.countriesSwipeRefresh.isEnabled = false
    }
}