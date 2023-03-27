package com.example.noteapplication.ui.dashboard.add

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.noteapplication.model.Note
import com.example.noteapplication.R
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class AddNoteFragment : Fragment() {

    private val viewModel: AddViewModel by viewModels()
    var date: Long = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dateView = view.findViewById<TextInputEditText>(R.id.et_date)
        val title = view.findViewById<TextInputEditText>(R.id.et_title)
        val message = view.findViewById<TextInputEditText>(R.id.et_message)

        dateView.setOnClickListener {

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
            val titleText = title.text.toString().trim()
            val messageText = message.text.toString().trim()

            if (titleText.isNotEmpty() && messageText.isNotEmpty() && dateView.text.toString().trim().isNotEmpty()){

                viewModel.userId.observe(viewLifecycleOwner){userId ->
                    viewModel.addNote(Note(null, titleText, messageText, Date(date), userId))
                }

                viewModel.getUserId(viewModel.getUser()?.email ?: "")

                title.setText("")
                message.setText("")
                dateView.setText("")

                Toast.makeText(requireContext(), getString(R.string.note_add), Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), getString(R.string.alert_fill_fields), Toast.LENGTH_SHORT).show()
            }
        }
    }
}