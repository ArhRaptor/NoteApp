package com.example.noteapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.noteapplication.R
import com.example.noteapplication.extencions.replaceFragment
import com.example.noteapplication.ui.dashboard.DashboardFragment
import com.google.android.material.textfield.TextInputLayout

class AuthorizationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tilLogin = view.findViewById<TextInputLayout>(R.id.til_email)
        val etLogin: EditText? = tilLogin.editText
        etLogin?.doAfterTextChanged {
            tilLogin.error = null
        }

        val tilPassword = view.findViewById<TextInputLayout>(R.id.til_password)
        val etPassword: EditText? = tilPassword.editText
        etPassword?.doAfterTextChanged {
            tilPassword.error = null
        }

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            if (etLogin?.text.toString().isEmpty()) {
                tilLogin.error = getString(R.string.obligatory_field)
            }
            if (etPassword?.text.toString().isEmpty()) {
                tilPassword.error = getString(R.string.obligatory_field)
            } else {
                parentFragmentManager.replaceFragment(R.id.fv_container, DashboardFragment())
            }
        }

        view.findViewById<TextView>(R.id.tv_sign_up).setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.fv_container, RegistrationFragment())
        }
    }
}
