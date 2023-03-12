package com.example.noteapplication.ui.dashboard.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.R
import com.example.noteapplication.model.Note
import com.example.noteapplication.ui.dashboard.list.NoteRecyclerViewAdapter
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat

class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSearch = view.findViewById<TextInputEditText>(R.id.et_search)
        tvSearch.doAfterTextChanged {
            if (tvSearch.text.toString().isNotEmpty()) {

                viewModel.notesList.observe(viewLifecycleOwner) {

                    val listView = view.findViewById<RecyclerView>(R.id.rv_list)
                    listView.adapter = SearchRecyclerViewAdapter(it as ArrayList<Note>)
                    listView.layoutManager = LinearLayoutManager(context)

                }
                viewModel.findNote(tvSearch.text.toString())
            }
        }
    }
}