package com.example.noteapplication.ui.dashboard.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.R
import com.example.noteapplication.model.Note

class SearchRecyclerViewAdapter(private val notesList:ArrayList<Note>): RecyclerView.Adapter<SearchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
       return SearchViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.item_search_note, parent, false))
    }

    override fun getItemCount(): Int {
       return notesList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(notesList[position])
    }
}