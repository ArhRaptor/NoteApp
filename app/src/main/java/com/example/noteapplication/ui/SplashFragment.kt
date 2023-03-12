package com.example.noteapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.noteapplication.R
import com.example.noteapplication.extencions.replaceFragment
import com.example.noteapplication.ui.authorization.AuthorizationFragment

class SplashFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_discover).setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.fv_container, OnbordingStepFragment())
        }

        view.findViewById<TextView>(R.id.tv_login).setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.fv_container, AuthorizationFragment())
        }

    }
}