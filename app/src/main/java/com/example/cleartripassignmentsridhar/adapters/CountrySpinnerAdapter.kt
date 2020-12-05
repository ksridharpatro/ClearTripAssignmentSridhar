package com.example.cleartripassignmentsridhar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.cleartripassignmentsridhar.R
import com.example.cleartripassignmentsridhar.models.Country

class CountrySpinnerAdapter(countries: List<Country>, context: Context) :
    ArrayAdapter<Country>(context, 0, countries) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        // It is used to set our custom view.
        val itemView: View
        if (convertView == null) {
            itemView =
                LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false)
        } else {
            itemView = convertView
        }
        val textViewName = itemView.findViewById<TextView>(R.id.countryName)
        val currentItem: Country? = getItem(position)
        if (currentItem != null) {
            textViewName.text = currentItem.countryName
        }
        return itemView
    }
}