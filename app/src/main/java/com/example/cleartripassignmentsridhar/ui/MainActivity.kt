package com.example.cleartripassignmentsridhar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleartripassignmentsridhar.R
import com.example.cleartripassignmentsridhar.repository.CountryRepository

class MainActivity : AppCompatActivity() {

    private lateinit var vieModel: CountryVieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryRepository = CountryRepository()
        val countryViewModelFactory = CountryViewModelFactory(countryRepository)
        vieModel = ViewModelProvider(this, countryViewModelFactory).get(CountryVieModel::class.java)
    }
}