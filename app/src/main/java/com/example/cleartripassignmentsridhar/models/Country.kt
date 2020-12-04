package com.example.cleartripassignmentsridhar.models

import com.example.cleartripassignmentsridhar.enums.InputField

class Country {
    private lateinit var countryCode: String
    private lateinit var countryName: String
    private lateinit var mandatoryFields: List<InputField>
}