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

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val tilName = findViewById<TextInputLayout>(R.id.til_name)
        val etName:EditText? = tilName.editText
        etName?.doAfterTextChanged {
            if (!isValidName(etName.text.toString().trim())){
                tilName.error = getString(R.string.error_name)
            }else{
                tilName.error = null
            }
        }

        val tilSurname = findViewById<TextInputLayout>(R.id.til_surname)
        val etSurname:EditText? = tilSurname.editText
        etSurname?.doAfterTextChanged {
            if (!isValidName(etSurname.text.toString().trim())){
                tilSurname.error = getString(R.string.error_name)
            }else{
                tilSurname.error = null
            }
        }

        val tilEmail = findViewById<TextInputLayout>(R.id.til_email)
        val etEmail:EditText? = tilEmail.editText
        etEmail?.doAfterTextChanged {
            if (!isValidEmail(etEmail.text.toString().trim())){
                tilEmail.error = getString(R.string.error_name)
            }else{
                tilEmail.error = null
            }
        }

        val tilPassword = findViewById<TextInputLayout>(R.id.til_password)
        val etPassword:EditText? = tilPassword.editText
        etPassword?.doAfterTextChanged {
            if (!isValidPassword(etPassword.text.toString().trim())){
                tilPassword.error = getString(R.string.error_name)
            }else{
                tilPassword.error = null
            }
        }


        findViewById<Button>(R.id.btn_sign_up).setOnClickListener {
            Toast.makeText(this, "Нажал кнопку Sign-up", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.tv_login).setOnClickListener {
            startActivity(Intent(this, AuthorizationActivity::class.java))
        }
    }
}