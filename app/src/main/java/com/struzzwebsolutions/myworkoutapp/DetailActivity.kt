package com.struzzwebsolutions.myworkoutapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_WORKOUT_ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag: WorkoutDetailFragment = supportFragmentManager.findFragmentById(R.id.detail_frag) as WorkoutDetailFragment
        val workoutId: Int = intent.extras.get(EXTRA_WORKOUT_ID) as Int
        frag.workoutId = workoutId
    }
}
