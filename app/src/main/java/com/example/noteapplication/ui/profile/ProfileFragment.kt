package com.example.noteapplication.ui.profile

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

    private val viewModel:ProfileViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tv_logout).setOnClickListener {
            activity?.supportFragmentManager?.replaceFragment(R.id.fv_container, SplashFragment())
        }

        view.findViewById<TextView>(R.id.tv_notes_count).text = "${viewModel.countNotes()} notes"

        view.findViewById<TextView>(R.id.tv_delete_all_notes).setOnClickListener{
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.attentionon))
                .setMessage(getString(R.string.is_all_delete))
                .setPositiveButton(getString(R.string.delete)){ _, _ ->
                    viewModel.deleteAllNotes()
                    view.findViewById<TextView>(R.id.tv_notes_count).text = "${viewModel.countNotes()} notes"
                }
                .setNegativeButton(getString(R.string.cancel)){ dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}