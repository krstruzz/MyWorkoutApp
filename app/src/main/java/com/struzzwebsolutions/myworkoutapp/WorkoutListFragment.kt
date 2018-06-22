package com.struzzwebsolutions.myworkoutapp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


class WorkoutListFragment : ListFragment() {

    interface Listener {
        fun itemClicked(id: Long)
    }

    private var listener: Listener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.listener = context as Listener
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        listener?.itemClicked(id)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val names = arrayOfNulls<String>(Workout.workouts.size)
        Workout.workouts.forEachIndexed { index, workout -> names[index] = workout.toString()  }
        listAdapter = ArrayAdapter<String>(
                inflater.context,
                android.R.layout.simple_list_item_1,
                names)

        return super.onCreateView(inflater, container, savedInstanceState)
        }
    }

