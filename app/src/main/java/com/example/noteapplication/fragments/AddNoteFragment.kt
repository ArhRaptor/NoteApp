package com.example.noteapplication.fragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.noteapplication.Note
import com.example.noteapplication.NotesStorage
import com.example.noteapplication.R
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class AddNoteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.fragment_add_note, container, false)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val date = view.findViewById<TextInputEditText>(R.id.et_date)
        val title = view.findViewById<TextInputEditText>(R.id.et_title)
        val message = view.findViewById<TextInputEditText>(R.id.et_message)

        date.setOnClickListener {

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
                date.setText(dateFormat.format(it))
            }

            datePicker.show(parentFragmentManager, "datePicker")

        }

       view.findViewById<Button>(R.id.btn_add).setOnClickListener {
            val titleText = title.text.toString().trim()
            val messageText = message.text.toString().trim()

            if (titleText.isNotEmpty() && messageText.isNotEmpty() && date.text.toString().trim().isNotEmpty()){
                NotesStorage.notesList.add(Note(titleText, messageText, Date()))

                title.setText("")
                message.setText("")
                date.setText("")

                Toast.makeText(requireContext(), getString(R.string.note_add), Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), getString(R.string.alert_fill_fields), Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<TextView>(R.id.tv_back).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fv_container, NotesListFragment())
                .commit()
        }
    }
}