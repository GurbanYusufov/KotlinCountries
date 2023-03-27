package com.yusufov.kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yusufov.kotlincountries.model.Country

class CountryViewModel:ViewModel(){
    val countryLiveData=MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country=Country("Turkey","Asia","Ankara","TRY","Turkish","www.ss.com")
        countryLiveData.value=country
    }
}