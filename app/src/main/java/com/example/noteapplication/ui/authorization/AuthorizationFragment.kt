package com.example.noteapplication.ui.authorization

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
import com.example.noteapplication.databinding.FragmentAuthorizationBinding
import javax.inject.Inject

class AuthorizationFragment : Fragment() {

    @Inject
    lateinit var viewModelsProvider: AuthorizationViewModelsProvider

    private var binding: FragmentAuthorizationBinding? = null
    private val viewModel: AuthorizationViewModel by viewModels {
        viewModelsProvider
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.applicationComponent?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.etEmail?.doAfterTextChanged {
            binding?.tilEmail?.error = null
        }

        binding?.etPassword?.doAfterTextChanged {
            binding?.tilPassword?.error = null
        }

        binding?.btnLogin?.setOnClickListener {
            if (binding?.etEmail?.text.toString().isEmpty()) {
                binding?.tilEmail?.error = getString(R.string.obligatory_field)
            }
            if (binding?.etPassword?.text.toString().isEmpty()) {
                binding?.tilPassword?.error = getString(R.string.obligatory_field)
            } else {
                viewModel.user.observe(viewLifecycleOwner) {
                    if (it != null) {
                        if (it.password == binding?.etPassword?.text.toString()) {
                            viewModel.login()
                            viewModel.putUser(it)
                            findNavController().navigate(AuthorizationFragmentDirections.actionAuthorizationFragmentToDashboardFragment())
                        } else {
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.wrong_password),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.user_not_found),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                viewModel.getUser(binding?.etEmail?.text.toString())
            }
        }

        binding?.tvSignUp?.setOnClickListener {
            findNavController().navigate(AuthorizationFragmentDirections.actionAuthorizationFragmentToRegistrationFragment())
        }
    }
}
