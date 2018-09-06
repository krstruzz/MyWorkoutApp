package com.struzzwebsolutions.myworkoutapp

import android.widget.TextView
import java.util.Locale
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_stopwatch.*

class StopwatchFragment: Fragment(), View.OnClickListener {
    //Number of seconds displayed on the stopwatch.
    private var seconds: Int = 0
    //Is the stopwatch running?
    private var running: Boolean = false
    private var wasRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.start_button -> onClickStart()
            R.id.stop_button -> onClickStop()
            R.id.reset_button -> onClickReset()
        }
    }

    private fun onClickStart() {
        running = true
    }

    private fun onClickStop() {
        running = false
    }

    private fun onClickReset() {
        running = false
        seconds = 0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Set the fragment's layout and start the runTimer() method, passing in the layout
        val layout: View = inflater.inflate(R.layout.fragment_stopwatch, container, false)
        runTimer(layout)
        val startButton = layout.findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener(this)
        val stopButton = layout.findViewById<Button>(R.id.stop_button)
        stopButton.setOnClickListener(this)
        val resetButton = layout.findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener(this)
        return layout
    }

    override fun onPause() {
        super.onPause()
        //If the fragment's paused, record whether the stopwatch was running and stop it
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        //If the stopwatch was running before it was paused, set it running again
        if (wasRunning) {
            running = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning", wasRunning)
    }


    private fun runTimer(view: View) {
        val timeView: TextView = view.findViewById(R.id.time_view)
        //Putting the code in a Handler means it can run in the background thread
        val handler: Handler? = Handler()
        val runnable = object : Runnable {
            override fun run() {
                val hours: Int = seconds/3600
                val minutes: Int = (seconds%3600)/60
                var secs = seconds%60
                val time: String = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, seconds)
                //Display the number of seconds that have passed in the stopwatch
                timeView.text = time
                //If the stopwatch is running, increment the number of seconds
                if (running) { seconds++ }
                //Run the handler code every second
                handler?.postDelayed(this, 1000)
            }
        }
        handler?.post(runnable)

        }
    }