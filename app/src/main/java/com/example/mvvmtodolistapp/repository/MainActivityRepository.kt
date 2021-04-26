package com.example.mvvmtodolistapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmtodolistapp.model.ServicesSetterGetter
import com.example.mvvmtodolistapp.model.ToDoItem
import com.example.mvvmtodolistapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {
    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()
    val serviceToDo = MutableLiveData<ToDoItem>()

    fun getServicesApiCall(): MutableLiveData<ServicesSetterGetter> {

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object: Callback<ServicesSetterGetter> {
            override fun onFailure(call: Call<ServicesSetterGetter>, t: Throwable) {

                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<ServicesSetterGetter>,
                response: Response<ServicesSetterGetter>
            ) {

                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                val msg = data!!.title

                serviceSetterGetter.value = ServicesSetterGetter(title = msg)
            }
        })

        return serviceSetterGetter
    }

    fun getAllServicesApiCall(): MutableLiveData<ServicesSetterGetter> {

        val call = RetrofitClient.apiInterface.getAllServices()

        call.enqueue(object : Callback<List<ServicesSetterGetter>> {
            override fun onFailure(call: Call<List<ServicesSetterGetter>>, t: Throwable) {

                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<ServicesSetterGetter>>,
                response: Response<List<ServicesSetterGetter>>
            ) {

                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                val msg = data!![1].title


                serviceSetterGetter.value = ServicesSetterGetter(title = msg)
            }
        })

        return serviceSetterGetter
    }

}