package com.example.cleartripassignmentsridhar.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleartripassignmentsridhar.repository.CountryRepository

class CountryViewModelFactory(
    private val countryRepository: CountryRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountryVieModel(countryRepository) as T
    }
}