package com.struzzwebsolutions.myworkoutapp

import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class TempActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)
        if (savedInstanceState == null) {
            val stopwatch = StopwatchFragment()
            val fragTrans: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragTrans.add(R.id.stopwatch_container, stopwatch)
            fragTrans.addToBackStack(null)
            fragTrans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            fragTrans.commit()
        }
    }
}
