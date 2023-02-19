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

        val tilLogin = findViewById<TextInputLayout>(R.id.til_email)
        val etLogin: EditText? = tilLogin.editText
        etLogin?.doAfterTextChanged {
            tilLogin.error = null
        }

        val tilPassword = findViewById<TextInputLayout>(R.id.til_password)
        val etPassword: EditText? = tilPassword.editText
        etPassword?.doAfterTextChanged {
            tilPassword.error = null
        }

        findViewById<Button>(R.id.btn_login).setOnClickListener {
            if (etLogin?.text.toString().isEmpty()) {
                tilLogin.error = getString(R.string.obligatory_field)
            }
            if (etPassword?.text.toString().isEmpty()) {
                tilPassword.error = getString(R.string.obligatory_field)
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
