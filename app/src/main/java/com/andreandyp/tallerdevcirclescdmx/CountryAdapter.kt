package com.andreandyp.tallerdevcirclescdmx

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import com.andreandyp.tallerdevcirclescdmx.databinding.ItemCountryBinding
import com.andreandyp.tallerdevcirclescdmx.domain.Country

class CountryAdapter(
    private val imageLoader: ImageLoader,
    var values: List<Country>,
) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.countryFlag.load(item.flag, imageLoader) {
            placeholder(R.drawable.ic_baseline_cloud_download_24)
            error(R.drawable.ic_baseline_cloud_off_24)
        }
        holder.countryName.text = item.name
        holder.capitalName.text = item.capitalName
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        val countryFlag: ImageView = binding.countryFlagImageView
        val countryName: TextView = binding.countryNameTextView
        val capitalName: TextView = binding.countryCapitalNameTextView
    }

}