package com.example.noteapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputLayout

class AuthorizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        val til_login = findViewById<TextInputLayout>(R.id.til_email)
        val et_login: EditText? = til_login.editText
        et_login?.doAfterTextChanged {
            til_login.error = null
        }

        val til_pass = findViewById<TextInputLayout>(R.id.til_password)
        val et_pass: EditText? = til_pass.editText
        et_pass?.doAfterTextChanged {
            til_pass.error = null
        }

        findViewById<Button>(R.id.btn_login).setOnClickListener {
            if (et_login?.text.toString().isEmpty()) {
                til_login.error = getString(R.string.obligatory_field)
            }
            if (et_pass?.text.toString().isEmpty()) {
                til_pass.error = getString(R.string.obligatory_field)
            } else {
                Toast.makeText(applicationContext, "Все ок!!!! ", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        findViewById<TextView>(R.id.tv_sign_up).setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }


    }
}
