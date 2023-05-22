package com.example.noteapplication.ui.dashboard.profile

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.noteapplication.App
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentProfileBinding
import com.example.noteapplication.ui.dashboard.DashboardFragment
import com.example.noteapplication.ui.dashboard.DashboardFragmentDirections
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject

class ProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelProvider: ProfileViewModelProvider

    private var binding: FragmentProfileBinding? = null
    private val viewModel: ProfileViewModel by viewModels{
        viewModelProvider
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
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.tvUser?.text = "${viewModel.getUser()?.firstName} ${viewModel.getUser()?.lastName}"

        binding?.tvLogout?.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.attentionon))
                .setMessage(getString(R.string.is_exit))
                .setPositiveButton(getString(R.string.exit)) { _, _ ->
                    viewModel.exit()
                    activity?.findNavController(R.id.fv_container)?.navigate(DashboardFragmentDirections.actionDashboardFragmentToSplashFragment())
                }
                .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }


        binding?.tvDeleteProfile?.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.attentionon))
                .setMessage(getString(R.string.is_profile_delete))
                .setPositiveButton(getString(R.string.delete)) { _, _ ->
                    viewModel.exit()
                    findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToSplashFragment())
                    viewModel.deleteUser(viewModel.getUser())
                }
                .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        viewModel.run {
            notesList.observe(viewLifecycleOwner) {
                binding?.tvNotesCount?.text = "${it.size} notes"
            }
            userId.observe(viewLifecycleOwner) {
                viewModel.notes(it)
            }
            getUserId(viewModel.getUser()?.email ?: "")
        }

        binding?.tvDeleteAllNotes?.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.attentionon))
                .setMessage(getString(R.string.is_all_delete))
                .setPositiveButton(getString(R.string.delete)) { _, _ ->
                    viewModel.userId.observe(viewLifecycleOwner) {
                        viewModel.deleteAllNotes(it)
                    }
                    viewModel.getUserId(viewModel.getUser()?.email ?: "")

                }
                .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}