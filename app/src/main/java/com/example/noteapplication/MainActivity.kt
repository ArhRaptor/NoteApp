package com.example.noteapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapplication.fragments.SplashFragment

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fv_container, SplashFragment())
            .addToBackStack(null)
            .commit()
    }
}