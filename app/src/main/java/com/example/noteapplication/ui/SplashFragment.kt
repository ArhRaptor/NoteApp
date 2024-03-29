package com.example.noteapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.noteapplication.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var binding: FragmentSplashBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSplashBinding.inflate(inflater,container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnDiscover?.setOnClickListener {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToOnbordingStepFragment())
        }

        binding?.tvLogin?.setOnClickListener{
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToAuthorizationFragment())
        }
    }
}