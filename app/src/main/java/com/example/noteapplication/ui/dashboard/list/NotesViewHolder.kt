package com.example.noteapplication.ui.dashboard.list

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.model.Note
import com.example.noteapplication.R
import java.text.SimpleDateFormat

class NotesViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    @SuppressLint("SimpleDateFormat")
    fun bind(note: Note) {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")

        view.findViewById<TextView>(R.id.tv_title).text = note.title
        view.findViewById<TextView>(R.id.tv_message).text = note.message
        view.findViewById<TextView>(R.id.tv_date).text = dateFormat.format(note.date)
    }
}