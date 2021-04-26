package com.example.mvvmtodolistapp.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtodolistapp.R
import com.example.mvvmtodolistapp.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var context: Context

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        btnClick.setOnClickListener {

            wp7progressBar.showProgressBar()

//            mainActivityViewModel.getUser()!!.observe(this, Observer { serviceSetterGetter ->
//
//                wp7progressBar.hideProgressBar()
//
//                val msg = serviceSetterGetter.title
//
//                lblResponse.text = msg
//
//            })

            mainActivityViewModel.getItem()!!.observe(this, Observer {

                wp7progressBar.hideProgressBar()

                val msg = it.title

                lblResponse.text = msg

            })

        }

    }
}