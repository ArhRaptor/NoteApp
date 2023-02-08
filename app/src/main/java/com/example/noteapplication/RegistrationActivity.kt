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

        val til_name = findViewById<TextInputLayout>(R.id.til_name)
        val et_name:EditText? = til_name.editText
        et_name?.doAfterTextChanged {
            if (!isValidName(et_name.text.toString().trim())){
                til_name.error = getString(R.string.error_name)
            }else{
                til_name.error = null
            }
        }

        val til_surnamename = findViewById<TextInputLayout>(R.id.til_surname)
        val et_surnamename:EditText? = til_surnamename.editText
        et_surnamename?.doAfterTextChanged {
            if (!isValidName(et_surnamename.text.toString().trim())){
                til_surnamename.error = getString(R.string.error_name)
            }else{
                til_surnamename.error = null
            }
        }

        val til_email = findViewById<TextInputLayout>(R.id.til_email)
        val et_email:EditText? = til_email.editText
        et_email?.doAfterTextChanged {
            if (!isValidEmail(et_email.text.toString().trim())){
                til_email.error = getString(R.string.error_name)
            }else{
                til_email.error = null
            }
        }

        val til_password = findViewById<TextInputLayout>(R.id.til_password)
        val et_password:EditText? = til_password.editText
        et_password?.doAfterTextChanged {
            if (!isValidPassword(et_password.text.toString().trim())){
                til_password.error = getString(R.string.error_name)
            }else{
                til_password.error = null
            }
        }


        findViewById<Button>(R.id.btn_sign_up).setOnClickListener {
            Toast.makeText(this, "Нажал кнопку Sign-up", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.tv_login).setOnClickListener {
            startActivity(Intent(this, AuthorizationActivity::class.java))
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}".toRegex())
    }
    private fun isValidName(name: String):Boolean{
        return name.matches("[a-zA-Zа-яёА-ЯЁ]{3,255}".toRegex())
    }
    private fun isValidPassword(password:String):Boolean{
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,50}\$".toRegex())
    }
}