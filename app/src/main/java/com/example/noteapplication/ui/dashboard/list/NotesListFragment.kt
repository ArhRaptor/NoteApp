package com.example.noteapplication.ui.dashboard.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.App
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentNotesListBinding
import com.example.noteapplication.model.Note
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject

class NotesListFragment : Fragment() {

    @Inject
    lateinit var viewModelProvider: ListViewModelProvider

    private var binding: FragmentNotesListBinding? = null
    private val viewModel: ListViewModel by viewModels{
        viewModelProvider
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.applicationComponent?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            noteList.observe(viewLifecycleOwner) {
                setRecyclerView(it as ArrayList<Note>)
            }

            userId.observe(viewLifecycleOwner) {
                viewModel.loadNotes(it)
            }

            getUserId(viewModel.getUser()?.email ?: "")
        }

    }

    private fun setRecyclerView(notes: ArrayList<Note>) {

        val adapter = NoteRecyclerViewAdapter(parentFragmentManager, notes)

        binding?.rvNotesList.let { recyclerView ->
            recyclerView?.adapter = adapter
            recyclerView?.layoutManager = LinearLayoutManager(requireContext())


            val itemTouchHelper = ItemTouchHelper(object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val note = viewHolder.adapterPosition
                    MaterialAlertDialogBuilder(requireContext())
                        .setTitle(getString(R.string.attentionon))
                        .setMessage(getString(R.string.is_delete))
                        .setPositiveButton(getString(R.string.delete)) {_, _ ->
                            viewModel.deleteNote(notes[note])
                            notes.removeAt(note)
                            adapter.notifyItemRemoved(note)
                        }
                        .setNegativeButton(getString(R.string.cancel)) {dialog, _ ->
                            adapter.notifyItemChanged(note)
                            dialog.dismiss()
                        }
                        .show()
                }
            })

            itemTouchHelper.attachToRecyclerView(recyclerView)
        }
    }
}