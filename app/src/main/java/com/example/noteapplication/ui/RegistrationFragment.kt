package com.example.noteapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.noteapplication.R
import com.example.noteapplication.extencions.replaceFragment
import com.example.noteapplication.isValidEmail
import com.example.noteapplication.isValidName
import com.example.noteapplication.isValidPassword
import com.google.android.material.textfield.TextInputLayout

class RegistrationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tilName = view.findViewById<TextInputLayout>(R.id.til_name)
        val etName:EditText? = tilName.editText
        etName?.doAfterTextChanged {
            if (!isValidName(etName.text.toString().trim())){
                tilName.error = getString(R.string.error_name)
            }else{
                tilName.error = null
            }
        }

        val tilSurname = view.findViewById<TextInputLayout>(R.id.til_surname)
        val etSurname:EditText? = tilSurname.editText
        etSurname?.doAfterTextChanged {
            if (!isValidName(etSurname.text.toString().trim())){
                tilSurname.error = getString(R.string.error_name)
            }else{
                tilSurname.error = null
            }
        }

        val tilEmail = view.findViewById<TextInputLayout>(R.id.til_email)
        val etEmail:EditText? = tilEmail.editText
        etEmail?.doAfterTextChanged {
            if (!isValidEmail(etEmail.text.toString().trim())){
                tilEmail.error = getString(R.string.error_name)
            }else{
                tilEmail.error = null
            }
        }

        val tilPassword = view.findViewById<TextInputLayout>(R.id.til_password)
        val etPassword:EditText? = tilPassword.editText
        etPassword?.doAfterTextChanged {
            if (!isValidPassword(etPassword.text.toString().trim())){
                tilPassword.error = getString(R.string.error_name)
            }else{
                tilPassword.error = null
            }
        }


        view.findViewById<Button>(R.id.btn_sign_up).setOnClickListener {
            Toast.makeText(requireContext(), "Нажал кнопку Sign-up", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<TextView>(R.id.tv_login).setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.fv_container, AuthorizationFragment())
        }
    }
}