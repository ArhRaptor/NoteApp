package com.example.noteapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AuthorizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        findViewById<Button>(R.id.btn_login).setOnClickListener {
            Toast.makeText(this, "Нажал кнопку Log-in", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.tv_sign_up).setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }
}
