package com.example.noteapplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class UnboardingStepActivity : AppCompatActivity() {
    private var runnable: Runnable? = null
    val handler = Handler()

    val listLayout = listOf(
        R.layout.activity_unboarding_step1,
        R.layout.activity_unboarding_step2,
        R.layout.activity_unboarding_step3,
        R.layout.activity_unboarding_step4,
        R.layout.activity_unboarding_step5
    )

    @RequiresApi(Build.VERSION_CODES.Q)
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

    }

    private fun finishList(){
        handler.removeCallbacks(runnable as Runnable)
        startActivity(Intent(applicationContext, AuthorizationActivity::class.java))
    }

}