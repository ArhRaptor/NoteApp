package com.example.noteapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        findViewById<Button>(R.id.btn_discover).setOnClickListener {
            startActivity(Intent(this, UnboardingStepActivity::class.java))
        }

        findViewById<TextView>(R.id.tv_login).setOnClickListener {
            startActivity(Intent(this, AuthorizationActivity::class.java))
        }
    }
}