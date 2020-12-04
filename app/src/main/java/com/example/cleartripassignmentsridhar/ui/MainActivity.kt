package com.example.cleartripassignmentsridhar.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleartripassignmentsridhar.R
import com.example.cleartripassignmentsridhar.repository.CountryRepository
import com.example.cleartripassignmentsridhar.util.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vieModel: CountryVieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryRepository = CountryRepository()
        val countryViewModelFactory = CountryViewModelFactory(countryRepository)
        vieModel = ViewModelProvider(
            this,
            countryViewModelFactory
        ).get(CountryVieModel::class.java)
        vieModel.countryResource.observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    groupUserDetails.visibility = View.VISIBLE
                    Toast.makeText(this, it.data.toString(), Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    groupUserDetails.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    groupUserDetails.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}