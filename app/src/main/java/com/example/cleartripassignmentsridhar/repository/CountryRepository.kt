package com.example.cleartripassignmentsridhar.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleartripassignmentsridhar.api.CountryApi
import com.example.cleartripassignmentsridhar.api.RetrofitInstance
import com.example.cleartripassignmentsridhar.models.Country
import com.example.cleartripassignmentsridhar.util.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class CountryRepository {
    private val logTag = CountryRepository::class.simpleName

    private val _countryResource: MutableLiveData<Resource<List<Country>>> = MutableLiveData()

    fun getCountries(): LiveData<Resource<List<Country>>> {
        _countryResource.postValue(Resource.loading())

        val countryApi: CountryApi = RetrofitInstance.countryApi
        val result: Call<String> = countryApi.countries()

        result.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                try {
                    Log.d(logTag, response.body() ?: "")
                } catch (e: IOException) {
                    Log.d(logTag, "IOException")
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                Log.d(logTag, "failed")
            }
        })
        return _countryResource
    }
}