package com.example.universeapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.universeapp.R
import com.example.universeapp.domain.adapters.PlanetsAdapter
import com.example.universeapp.domain.models.Planet
import com.example.universeapp.presentation.viewmodels.PlanetsViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlanetsActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planets)

        val planetsViewModel : PlanetsViewModel by viewModels()

        recyclerView = findViewById(R.id.RVPlanets)
        progressBar = findViewById(R.id.progress_Bar)

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED){
            planetsViewModel.planetsState.collect{state ->
                val planets = state.data
                if (state.loading){
                    progressBar.visibility = ProgressBar.VISIBLE
                    recyclerView.visibility = RecyclerView.GONE
                }
                else{
                    progressBar.visibility = ProgressBar.GONE
                    recyclerView.visibility = RecyclerView.VISIBLE

                }

                if (state.error.isNotEmpty()){
                    Snackbar.make(this@PlanetsActivity, recyclerView, state.error, Snackbar.LENGTH_LONG).show()
                }

                recyclerView.adapter = PlanetsAdapter(planets){
                    val intent = Intent(this@PlanetsActivity, PlanetDetailActivity::class.java)
                        .apply {
                            putExtra("planetId", it._id)
                        }
                    startActivity(intent)
                }

            }
        }
        }

    }
}