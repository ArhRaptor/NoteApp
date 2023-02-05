package com.example.noteapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        findViewById<Button>(R.id.btn_sign_up).setOnClickListener {
            Toast.makeText(this, "Нажал кнопку Sign-up", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.tv_login).setOnClickListener {
            startActivity(Intent(this, AuthorizationActivity::class.java))
        }
    }
}