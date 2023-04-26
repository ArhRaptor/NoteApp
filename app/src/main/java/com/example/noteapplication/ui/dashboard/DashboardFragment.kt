package com.example.noteapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var binding: FragmentDashboardBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container ,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.bnvNavigation?.setupWithNavController(
            Navigation.findNavController(view.findViewById(R.id.dashboard_container))
        )
    }
}