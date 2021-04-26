package com.example.mvvmtodolistapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmtodolistapp.model.ServicesSetterGetter
import com.example.mvvmtodolistapp.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<ServicesSetterGetter>? = null

    fun getUser() : LiveData<ServicesSetterGetter>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }

    fun getItem() : LiveData<ServicesSetterGetter>? {
        servicesLiveData = MainActivityRepository.getAllServicesApiCall()
        return servicesLiveData
    }

}