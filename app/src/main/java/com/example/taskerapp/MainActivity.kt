package com.example.taskerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskerapp.fragments.list.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = ListFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, listFragment)
            .commit()


    }
}