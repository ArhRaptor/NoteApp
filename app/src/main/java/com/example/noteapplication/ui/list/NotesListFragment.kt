package com.example.noteapplication.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.R
import com.example.noteapplication.model.Note
import com.example.noteapplication.ui.NoteRecyclerViewAdapter
import com.example.noteapplication.ui.SplashFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class NotesListFragment : Fragment() {

    private val viewModel:ListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.noteList.observe(viewLifecycleOwner){
            setRecyclerView(it, view)
        }
        viewModel.loadNotes()
    }

   private fun setRecyclerView(notes:ArrayList<Note>, view:View){

       val adapter = NoteRecyclerViewAdapter(parentFragmentManager, notes)

       val listView = view.findViewById<RecyclerView>(R.id.rv_notes_list)
       listView.adapter = adapter
       listView.layoutManager = LinearLayoutManager(requireContext())

       view.findViewById<TextView>(R.id.tv_logout).setOnClickListener {
           parentFragmentManager.beginTransaction()
               .replace(R.id.fv_container, SplashFragment())
               .commit()
       }

       view.findViewById<TextView>(R.id.tv_add).setOnClickListener {
           parentFragmentManager.beginTransaction()
               .replace(R.id.fv_container, AddNoteFragment())
               .commit()
       }

       val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

           override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
               return false
           }

           override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
               val note = viewHolder.adapterPosition
               MaterialAlertDialogBuilder(requireContext())
                   .setTitle(getString(R.string.attentionon))
                   .setMessage(getString(R.string.is_delete))
                   .setPositiveButton(getString(R.string.delete)){ _, _ ->
                       notes.removeAt(note)
                       adapter.notifyItemRemoved(note)
                   }
                   .setNegativeButton(getString(R.string.cancel)){ dialog, _ ->
                       adapter.notifyItemChanged(note)
                       dialog.dismiss()
                   }
                   .show()
           }
       })

       itemTouchHelper.attachToRecyclerView(listView)
   }
}