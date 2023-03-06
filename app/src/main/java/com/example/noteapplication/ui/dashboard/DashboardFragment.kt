package com.example.noteapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.noteapplication.R
import com.example.noteapplication.extencions.replaceFragment
import com.example.noteapplication.ui.add.AddNoteFragment
import com.example.noteapplication.ui.list.NotesListFragment
import com.example.noteapplication.ui.profile.ProfileFragment
import com.example.noteapplication.ui.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.replaceFragment(R.id.dashboard_container, NotesListFragment())

        view.findViewById<BottomNavigationView>(R.id.bnv_navigation)
            .setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        childFragmentManager.replaceFragment(R.id.dashboard_container, NotesListFragment())
                        return@setOnItemSelectedListener true
                    }
                    R.id.search -> {
                        childFragmentManager.replaceFragment(R.id.dashboard_container, SearchFragment())
                        return@setOnItemSelectedListener true
                    }
                    R.id.create_note -> {
                        childFragmentManager.replaceFragment(R.id.dashboard_container, AddNoteFragment())
                        return@setOnItemSelectedListener true
                    }
                    R.id.profile -> {
                        childFragmentManager.replaceFragment(R.id.dashboard_container, ProfileFragment())
                        return@setOnItemSelectedListener true
                    }
                    else -> {
                        return@setOnItemSelectedListener true
                    }
                }
            }
    }
}