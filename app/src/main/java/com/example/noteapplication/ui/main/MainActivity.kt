package com.example.noteapplication.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapplication.R
import com.example.noteapplication.extencions.replaceFragment
import com.example.noteapplication.ui.SplashFragment
import com.example.noteapplication.ui.authorization.AuthorizationFragment
import com.example.noteapplication.ui.dashboard.DashboardFragment

class MainActivity: AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (viewModel.isStartApp()){
            if (viewModel.isLogin()){
                supportFragmentManager.replaceFragment(R.id.fv_container, DashboardFragment())
            }else{
                supportFragmentManager.replaceFragment(R.id.fv_container, AuthorizationFragment())
            }
        }else{
            supportFragmentManager.replaceFragment(R.id.fv_container, SplashFragment())
        }

        viewModel.startApp()
    }
}