package com.example.cleartripassignmentsridhar.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cleartripassignmentsridhar.models.Country
import com.example.cleartripassignmentsridhar.repository.CountryRepository
import com.example.cleartripassignmentsridhar.util.Resource

class CountryVieModel(
    private val countryRepository: CountryRepository
) : ViewModel() {

    var countryResource: LiveData<Resource<List<Country>>> = countryRepository.getCountries()

}