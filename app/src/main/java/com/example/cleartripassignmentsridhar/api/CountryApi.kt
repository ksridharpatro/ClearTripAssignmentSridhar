package com.example.cleartripassignmentsridhar.api

import retrofit2.Call
import retrofit2.http.GET

interface CountryApi {
    @GET("/names.json.")
    fun countries(): Call<String>
}