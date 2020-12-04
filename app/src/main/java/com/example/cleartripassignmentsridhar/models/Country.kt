package com.example.cleartripassignmentsridhar.models

import com.example.cleartripassignmentsridhar.enums.InputField

data class Country(
    val countryCode: String,
    val countryName: String,
    val mandatoryFields: List<InputField>,
)