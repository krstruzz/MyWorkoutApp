package com.struzzwebsolutions.myworkoutapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), WorkoutListFragment.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val button = findViewById<Button>(R.id.show_button)

    }

    override fun itemClicked(id: Long) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, id.toInt())
        startActivity(intent)
    }
}
