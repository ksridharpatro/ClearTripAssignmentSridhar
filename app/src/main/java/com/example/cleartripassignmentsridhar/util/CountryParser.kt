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
                val countryName = getStringFromJsonObject(jsonObject, key)
                val mandatoryFields: MutableList<InputField> = ArrayList()
                // Since "Name" is mandatory for all country
                mandatoryFields.add(InputField.NAME)
                //Since "Passport" is mandatory for only India & US
                if (key == "IN" || key == "US") {
                    mandatoryFields.add(InputField.PASSPORT_NUMBER)
                }
                countries.add(Country(key, countryName, mandatoryFields))
            }
        }
        return countries
    }
}