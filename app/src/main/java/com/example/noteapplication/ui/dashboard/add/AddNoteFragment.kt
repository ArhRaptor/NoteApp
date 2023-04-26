package com.example.noteapplication.ui.dashboard.add

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.noteapplication.App
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentAddNoteBinding
import com.example.noteapplication.model.Note
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class AddNoteFragment : Fragment() {

    @Inject
    lateinit var viewModelsProvider: AddViewModelProvider

    private val viewModel: AddViewModel by viewModels{
        viewModelsProvider
    }
    private var binding: FragmentAddNoteBinding? = null
    private var date: Long = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.applicationComponent?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)

        return binding?.root
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dateView = binding?.etDate
        val title = binding?.etTitle
        val message = binding?.etMessage

        dateView?.setOnClickListener {

            val constraintsBuilder =
                CalendarConstraints.Builder()
                    .setStart(System.currentTimeMillis())

            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText(getString(R.string.select_date))
                    .setCalendarConstraints(constraintsBuilder.build())
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()

            datePicker.addOnPositiveButtonClickListener {

                val dateFormat = SimpleDateFormat("dd/MM/yyyy")
                dateView.setText(dateFormat.format(it))
                date = it
            }

            datePicker.show(parentFragmentManager, "datePicker")

        }

       view.findViewById<Button>(R.id.btn_add).setOnClickListener {
            val titleText = title?.text.toString().trim()
            val messageText = message?.text.toString().trim()

            if (titleText.isNotEmpty() && messageText.isNotEmpty() && dateView?.text.toString().trim().isNotEmpty()){

                viewModel.userId.observe(viewLifecycleOwner){userId ->
                    viewModel.addNote(Note(null, titleText, messageText, Date(date), userId))
                }

                viewModel.getUserId(viewModel.getUser()?.email ?: "")

                title?.setText("")
                message?.setText("")
                dateView?.setText("")

                Toast.makeText(requireContext(), getString(R.string.note_add), Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), getString(R.string.alert_fill_fields), Toast.LENGTH_SHORT).show()
            }
        }
    }
}