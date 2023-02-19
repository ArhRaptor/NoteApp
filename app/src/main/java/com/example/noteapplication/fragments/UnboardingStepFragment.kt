package com.example.noteapplication.fragments


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.noteapplication.R

private var index = 0

class UnboardingStepFragment : Fragment() {

    private val fragments = arrayOf(
        R.layout.fragment_unboarding_step1,
        R.layout.fragment_unboarding_step2,
        R.layout.fragment_unboarding_step3,
        R.layout.fragment_unboarding_step4,
        R.layout.fragment_unboarding_step5)

    private val handler = Handler()
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
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fv_container, UnboardingStepFragment())
                    .commit()
            }
        }, 6000)
    }

    private fun finishList(){
        handler.removeCallbacksAndMessages(null)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fv_container, AuthorizationFragment())
            .commit()
    }
}