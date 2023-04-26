package com.example.noteapplication.ui.registration

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapplication.App
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentRegistrationBinding
import com.example.noteapplication.model.User
import com.example.noteapplication.utils.isValidEmail
import com.example.noteapplication.utils.isValidName
import com.example.noteapplication.utils.isValidPassword
import javax.inject.Inject

class RegistrationFragment : Fragment() {

    @Inject
    lateinit var registrationViewModelProvider: RegistrationViewModelProvider

    private var binding: FragmentRegistrationBinding? = null
    private val viewModel:RegistrationViewModel by viewModels{
        registrationViewModelProvider
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.applicationComponent?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var isNameEntered = false
        var isSurnameEntered = false
        var isEmailEntered = false
        var isPasswordEntered = false

        binding?.etName?.doAfterTextChanged {
            if (!isValidName(binding?.etName?.text.toString().trim())){
               binding?.tilName?.error = getString(R.string.error_name)
            }else{
                binding?.tilName?.error = null
                isNameEntered = true
            }
        }

        binding?.etSurname?.doAfterTextChanged {
            if (!isValidName(binding?.etSurname?.text.toString().trim())){
               binding?.tilSurname?.error = getString(R.string.error_name)
            }else{
                binding?.tilSurname?.error = null
                isSurnameEntered = true
            }
        }

        binding?.etEmail?.doAfterTextChanged {
            if (!isValidEmail(binding?.etEmail?.text.toString().trim())){
               binding?.tilEmail?.error = getString(R.string.error_name)
            }else{
                binding?.tilEmail?.error = null
                isEmailEntered = true
            }
        }

        binding?.etPassword?.doAfterTextChanged {
            if (!isValidPassword(binding?.etPassword?.text.toString().trim())){
               binding?.tilPassword?.error = getString(R.string.error_name)
            }else{
                binding?.tilPassword?.error = null
                isPasswordEntered = true
            }
        }

        binding?.btnSignUp?.setOnClickListener {

            if (isNameEntered && isSurnameEntered && isEmailEntered && isPasswordEntered) {
                val newUser = User(0, binding?.etName?.text.toString(), binding?.etSurname?.text.toString(), binding?.etEmail?.text.toString(), binding?.etPassword?.text.toString())
                viewModel.apply {
                    login()
                    addUser(newUser)
                    putUser(newUser)
                }
                findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToDashboardFragment())
            }else{
                Toast.makeText(requireContext(), getString(R.string.fill_fields), Toast.LENGTH_SHORT).show()
            }
        }

        binding?.tvLogin?.setOnClickListener {
            findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToAuthorizationFragment())
        }
    }
}