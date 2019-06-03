package com.javi.basket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.javi.basket.ViewModel.ViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewM = ViewModelProviders.of(this).get(ViewModel::class.java)
        viewM.getAll().observe(this, Observer{
            it.forEach{
                partido->
                Log.d("CUSTOM",partido.fecha.toString())
            }
        })
    }
}
