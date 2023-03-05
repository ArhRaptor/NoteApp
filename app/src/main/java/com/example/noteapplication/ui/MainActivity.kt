package com.example.noteapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapplication.R
import com.example.noteapplication.extencions.replaceFragment

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.replaceFragment(R.id.fv_container, SplashFragment())
    }
}