package com.example.noteapplication.extencions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.replaceFragment(idContainer : Int, fragment: Fragment) {
    beginTransaction().replace(idContainer, fragment).commit()
}