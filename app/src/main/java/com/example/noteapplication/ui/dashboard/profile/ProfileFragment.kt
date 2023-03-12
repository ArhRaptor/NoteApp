package com.example.noteapplication.ui.dashboard.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.noteapplication.R
import com.example.noteapplication.extencions.replaceFragment
import com.example.noteapplication.ui.SplashFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tv_user).text = "${viewModel.getUser()?.firstName} ${viewModel.getUser()?.lastName}"

        view.findViewById<TextView>(R.id.tv_logout).setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.attentionon))
                .setMessage(getString(R.string.is_exit))
                .setPositiveButton(getString(R.string.exit)){ _, _ ->
                    viewModel.exit()
                    activity?.supportFragmentManager?.replaceFragment(R.id.fv_container, SplashFragment())
                }
                .setNegativeButton(getString(R.string.cancel)){ dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }


        view.findViewById<TextView>(R.id.tv_delete_profile).setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.attentionon))
                .setMessage(getString(R.string.is_profile_delete))
                .setPositiveButton(getString(R.string.delete)){ _, _ ->
                    viewModel.exit()
                    activity?.supportFragmentManager?.replaceFragment(R.id.fv_container, SplashFragment())
                    viewModel.deleteUser(viewModel.getUser())
                }
                .setNegativeButton(getString(R.string.cancel)){ dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        viewModel.run {
            notesList.observe(viewLifecycleOwner){
                view.findViewById<TextView>(R.id.tv_notes_count).text = "${it.size} notes"
            }
            userId.observe(viewLifecycleOwner) {
                viewModel.notes(it)
            }
            getUserId(viewModel.getUser()?.email?:"")
        }

        view.findViewById<TextView>(R.id.tv_delete_all_notes).setOnClickListener{
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.attentionon))
                .setMessage(getString(R.string.is_all_delete))
                .setPositiveButton(getString(R.string.delete)){ _, _ ->
                    viewModel.userId.observe(viewLifecycleOwner){
                        viewModel.deleteAllNotes(it)
                    }
                    viewModel.getUserId(viewModel.getUser()?.email?:"")

                }
                .setNegativeButton(getString(R.string.cancel)){ dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}