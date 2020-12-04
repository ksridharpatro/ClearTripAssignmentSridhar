package com.example.cleartripassignmentsridhar.util

import com.example.cleartripassignmentsridhar.enums.InputField
import com.example.cleartripassignmentsridhar.models.Country
import org.json.JSONObject

object CountryParser {

    fun parseCountries(countriesJson: String?): List<Country> {
        val countries: MutableList<Country> = ArrayList()
        countriesJson?.let {
            val jsonObject = JSONObject(countriesJson)
            val keySet = getKeysFromJsonObject(jsonObject)
            for (key in keySet) {
                val country = Country()
                country.countryCode = key
                country.countryName = getStringFromJsonObject(jsonObject, key)
                val mandatoryFields: MutableList<InputField> = ArrayList()
                mandatoryFields.add(InputField.NAME)
                if (key == "IN" || key == "US") {
                    mandatoryFields.add(InputField.PASSPORT_NUMBER)
                }
                country.mandatoryFields = mandatoryFields
                countries.add(country)
            }
        }
        return countries
    }
}