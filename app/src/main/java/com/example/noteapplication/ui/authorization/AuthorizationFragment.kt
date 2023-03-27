package com.example.noteapplication.ui.authorization

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.noteapplication.R
import com.example.noteapplication.extencions.replaceFragment
import com.example.noteapplication.model.User
import com.example.noteapplication.ui.dashboard.DashboardFragment
import com.example.noteapplication.ui.registration.RegistrationFragment
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class AuthorizationFragment : Fragment() {

    private val viewModel: AuthorizationViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(requireContext())
            .inflate(R.layout.fragment_authorization, container, false)
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
                viewModel.user.observe(viewLifecycleOwner) {
                    if (it != null) {
                        if (it.password == etPassword?.text.toString()) {
                            viewModel.login()
                            viewModel.putUser(it)
                            parentFragmentManager.replaceFragment(R.id.fv_container, DashboardFragment())
                        } else {
                            Toast.makeText(requireContext(), getString(R.string.wrong_password), Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(requireContext(), getString(R.string.user_not_found), Toast.LENGTH_SHORT).show()
                    }
                }

                viewModel.getUser(etLogin?.text.toString())
            }
        }

        view.findViewById<TextView>(R.id.tv_sign_up).setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.fv_container, RegistrationFragment())
        }
    }
}
