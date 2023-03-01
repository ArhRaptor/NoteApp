package com.example.noteapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.R
import com.example.noteapplication.model.Note

class NoteRecyclerViewAdapter(private val fragmentManager: FragmentManager, private val notesList:ArrayList<Note>) : RecyclerView.Adapter<NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(notesList[position])

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(TEXT_MESSAGE, notesList[position].message)

            val dialog = BottomDialogFragment()
            dialog.arguments = bundle
            dialog.show(fragmentManager, "bottomDialog")
        }
    }
}