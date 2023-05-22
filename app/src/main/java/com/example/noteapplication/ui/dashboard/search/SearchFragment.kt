package com.example.noteapplication.ui.dashboard.search

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapplication.App
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentSearchBinding
import com.example.noteapplication.model.Note
import com.google.android.material.textfield.TextInputEditText
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    lateinit var searchViewModelProvider: SearchViewModelProvider

    private var binding: FragmentSearchBinding? = null
    private val viewModel: SearchViewModel by viewModels{
        searchViewModelProvider
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.applicationComponent?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSearch = view.findViewById<TextInputEditText>(R.id.et_search)
        binding?.etSearch?.doAfterTextChanged {
            if (binding?.etSearch?.text.toString().isNotEmpty()) {

                viewModel.notesList.observe(viewLifecycleOwner) {

                    binding?.rvList.let {recyclerView ->
                        recyclerView?.adapter = SearchRecyclerViewAdapter(it as ArrayList<Note>)
                        recyclerView?.layoutManager = LinearLayoutManager(context)
                    }
                }
                viewModel.findNote(tvSearch.text.toString())
            }
        }
    }
}