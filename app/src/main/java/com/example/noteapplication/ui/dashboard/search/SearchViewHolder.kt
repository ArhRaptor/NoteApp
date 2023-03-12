package com.example.noteapplication.ui.dashboard.search

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.R
import com.example.noteapplication.model.Note
import java.text.SimpleDateFormat

class SearchViewHolder(private val view: View):RecyclerView.ViewHolder(view) {

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    fun bind(note: Note){

        view.findViewById<TextView>(R.id.tv_date).text = "Posted ${SimpleDateFormat("dd/MM/yyyy").format(note.date)}"
        view.findViewById<TextView>(R.id.tv_title).text = note.title
        view.findViewById<TextView>(R.id.tv_description).text = note.message
    }
}