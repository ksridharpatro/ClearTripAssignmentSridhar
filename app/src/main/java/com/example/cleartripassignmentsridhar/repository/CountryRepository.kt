package com.example.cleartripassignmentsridhar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleartripassignmentsridhar.api.CountryApi
import com.example.cleartripassignmentsridhar.api.RetrofitInstance
import com.example.cleartripassignmentsridhar.models.Country
import com.example.cleartripassignmentsridhar.util.CountryParser
import com.example.cleartripassignmentsridhar.util.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class CountryRepository {

    private val _countryResource: MutableLiveData<Resource<List<Country>>> = MutableLiveData()

    fun getCountries(): LiveData<Resource<List<Country>>> {

        _countryResource.postValue(Resource.loading())

        val countryApi: CountryApi = RetrofitInstance.countryApi
        val result: Call<String> = countryApi.countries()

        result.enqueue(object : Callback<String?> {

            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                try {
                    _countryResource.postValue(
                        Resource.success(CountryParser.parseCountries(response.body()))
                    )
                } catch (e: IOException) {
                    _countryResource.postValue(
                        Resource.error("Error while fetching")
                    )
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                _countryResource.postValue(
                    Resource.error("Error while fetching")
                )
            }
        })
        return _countryResource
    }
}