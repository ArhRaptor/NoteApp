package com.example.noteapplication.ui


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.noteapplication.R
import com.example.noteapplication.extencions.replaceFragment

private var index = 0

class OnbordingStepFragment : Fragment() {

    private val fragments = arrayOf(
        R.layout.fragment_onbording_step1,
        R.layout.fragment_onbording_step2,
        R.layout.fragment_onbording_step3,
        R.layout.fragment_onbording_step4,
        R.layout.fragment_onbording_step5)

    private val handler = Handler(Looper.myLooper()!!)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(fragments[index], container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tv_skip).setOnClickListener{
            finishList()
        }
    }

    override fun onStart() {
        super.onStart()
        handler.postDelayed({
            index++
            if (index == fragments.size) {
                finishList()
            }else{
                parentFragmentManager.replaceFragment(R.id.fv_container, OnbordingStepFragment())
            }
        }, 6000)
    }

    private fun finishList(){
        handler.removeCallbacksAndMessages(null)
        findNavController().navigate(OnbordingStepFragmentDirections.actionOnbordingStepFragmentToAuthorizationFragment())
    }
}