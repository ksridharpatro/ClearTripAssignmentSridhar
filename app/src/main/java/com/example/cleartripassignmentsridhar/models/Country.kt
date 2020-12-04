package com.example.cleartripassignmentsridhar.models

import com.example.cleartripassignmentsridhar.enums.InputField

class Country {
    lateinit var countryCode: String
    lateinit var countryName: String
    lateinit var mandatoryFields: List<InputField>
}