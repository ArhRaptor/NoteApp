package com.example.noteapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.noteapplication.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

const val TEXT_MESSAGE = "textMessage"

class BottomDialogFragment: BottomSheetDialogFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.fragment_bottom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(TEXT_MESSAGE)?.let {
            view.findViewById<TextView>(R.id.tv_message_fragment).text = it
        }

        view.findViewById<Button>(R.id.btn_ok).setOnClickListener {
            dismiss()
        }
    }
}