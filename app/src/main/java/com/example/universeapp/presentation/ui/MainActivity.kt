package com.example.universeapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.universeapp.R
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {
    private lateinit var btnEnter : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEnter = findViewById(R.id.IBCohete)

        btnEnter.setOnClickListener {
            val intent = Intent(this, PlanetsActivity::class.java)
            startActivity(intent)
        }

    }
}