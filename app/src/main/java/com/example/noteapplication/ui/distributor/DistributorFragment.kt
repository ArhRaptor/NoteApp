package com.example.noteapplication.ui.distributor

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapplication.App
import com.example.noteapplication.databinding.FragmentDistributorBinding
import javax.inject.Inject

class DistributorFragment : Fragment() {

    @Inject
    lateinit var viewModelsProvider: DistributorViewModelProvider

    private var binding: FragmentDistributorBinding? = null
    private val viewModel: DistributorViewModel by viewModels{
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
        binding = FragmentDistributorBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.isStartApp()) {
            if (viewModel.isLogin()) {
                findNavController().navigate(DistributorFragmentDirections.actionDistributorFragmentToDashboardFragment())
            } else {
                findNavController().navigate(DistributorFragmentDirections.actionDistributorFragmentToAuthorizationFragment())
            }
        } else {
            findNavController().navigate(DistributorFragmentDirections.actionDistributorFragmentToSplashFragment())
        }
        viewModel.startApp()
    }
}