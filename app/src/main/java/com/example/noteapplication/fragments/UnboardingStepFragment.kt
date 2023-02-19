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



























/*    private var runnable: Runnable? = null
    val handler = Handler()


    val listLayout = listOf(
        R.layout.fragment_unboarding_step1,
        R.layout.fragment_unboarding_step2,
        R.layout.fragment_unboarding_step3,
        R.layout.fragment_unboarding_step4,
        R.layout.fragment_unboarding_step5
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(requireContext()).inflate(listLayout[0], container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        index++

        runnable = object : Runnable {
            override fun run() {
                parentFragmentManager.beginTransaction().replace(R.id.fv_container, UnboardingStepFragment()).commit()

                index++
                if (index == listLayout.size) {
                    finishList()
                }

                view.findViewById<TextView>(R.id.tv_skip)?.setOnClickListener {
                    finishList()
                }
                handler.postDelayed(this, 6000)
            }
        }
        handler.post(runnable as Runnable)

    }

*//*    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var index = 0

        runnable = object : Runnable {
            override fun run() {

                setContentView(listLayout[index])
                index++
                if (index == listLayout.size) {
                    finishList()
                }

                findViewById<TextView>(R.id.tv_skip).setOnClickListener {
                    finishList()
                }
                handler.postDelayed(this, 6000)
            }
        }
        handler.post(runnable as Runnable)

    }*//*

    private fun finishList(){
        handler.removeCallbacks(runnable as Runnable)
        parentFragmentManager.beginTransaction().replace(R.id.fv_container, AuthorizationFragment()).commit()
    }*/

}