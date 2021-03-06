package com.struzzwebsolutions.myworkoutapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class WorkoutDetailFragment : Fragment() {
    var workoutId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val stopwatch = StopwatchFragment()
            val fragTrans: FragmentTransaction = childFragmentManager.beginTransaction()
            fragTrans.add(R.id.stopwatch_container, stopwatch)
            fragTrans.addToBackStack(null)
            fragTrans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            fragTrans.commit()
        } else {
            workoutId = savedInstanceState.getInt("workoutId")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        val view = view
        if (view != null) {
            val title = view.findViewById<TextView>(R.id.textTitle)
            val workout = Workout.workouts[workoutId!!]
            title.text = workout.name
            val description = view.findViewById<TextView>(R.id.textDescription)
            description.text = workout.description
        }
    }
}
