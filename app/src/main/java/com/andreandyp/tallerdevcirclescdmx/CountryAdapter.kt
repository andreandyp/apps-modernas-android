package com.andreandyp.tallerdevcirclescdmx

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.andreandyp.tallerdevcirclescdmx.placeholder.PlaceholderContent.PlaceholderItem
import com.andreandyp.tallerdevcirclescdmx.databinding.ItemCountryBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class CountryAdapter(
    private val values: List<PlaceholderItem>
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
        holder.countryFlag.setImageResource(R.mipmap.ic_launcher)
        holder.countryName.text = item.id
        holder.capitalName.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        val countryFlag: ImageView = binding.countryFlagImageView
        val countryName: TextView = binding.countryNameTextView
        val capitalName: TextView = binding.countryCapitalNameTextView
    }

}