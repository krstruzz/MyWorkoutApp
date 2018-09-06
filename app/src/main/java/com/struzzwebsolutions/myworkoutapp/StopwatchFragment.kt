package com.struzzwebsolutions.myworkoutapp

import android.widget.TextView
import java.util.Locale
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

public class StopwatchFragment: Fragment() {
    //Number of seconds displayed on the stopwatch.
    var seconds: Int = 0
    //Is the stopwatch running?
    var running: Boolean = false
    var wasRunning: Boolean = false

}