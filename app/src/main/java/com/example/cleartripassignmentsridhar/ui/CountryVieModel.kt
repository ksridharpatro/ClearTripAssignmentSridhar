package com.example.cleartripassignmentsridhar.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cleartripassignmentsridhar.enums.InputField
import com.example.cleartripassignmentsridhar.models.Country
import com.example.cleartripassignmentsridhar.repository.CountryRepository
import com.example.cleartripassignmentsridhar.util.Resource

class CountryVieModel(
    countryRepository: CountryRepository
) : ViewModel() {

    var countryResource: LiveData<Resource<List<Country>>> = countryRepository.getCountries()

    fun validateUserDetails(country: Country, name: String, passport: String): String {
        if (InputField.NAME in country.mandatoryFields && name.isBlank()) {
            return "Error: Name is invalid"
        }
        if (InputField.PASSPORT_NUMBER in country.mandatoryFields && passport.isBlank()) {
            return "Error: Passport number invalid"
        }
        return "Validation Successful"
    }
}