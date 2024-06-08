package com.example.universeapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.universeapp.R
import com.example.universeapp.data.PlanetService
import com.example.universeapp.presentation.viewmodels.PlanetDetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class PlanetDetailActivity : AppCompatActivity() {

    private lateinit var planetName : TextView
    private lateinit var planetType : TextView
    private lateinit var planetDescription : TextView
    private lateinit var planetImage : ImageView
    private lateinit var planetMass : TextView
    private lateinit var planetDiameter : TextView
    private lateinit var planetGravity : TextView
    private lateinit var planetRotation : TextView
    private lateinit var planetTraslation : TextView
    private lateinit var planetDistance : TextView
    private lateinit var planetMoons : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)

        val planetDetailViewModel : PlanetDetailViewModel by viewModels()

        planetName = findViewById(R.id.TVTitlePlanet)
        planetType = findViewById(R.id.TVPlanetType)
        planetDescription = findViewById(R.id.TVPlanetDescription)
        planetImage = findViewById(R.id.imageViewPlanet)
        planetMass = findViewById(R.id.TVPlanetMass)
        planetDiameter = findViewById(R.id.TVPlanetDiameter)
        planetGravity = findViewById(R.id.TVPlanetGravity)
        planetRotation = findViewById(R.id.TVPlanetRotation)
        planetTraslation = findViewById(R.id.TVPlanetTraslation)
        planetDistance = findViewById(R.id.TVPlanetDistance)
        planetMoons = findViewById(R.id.TVPlanetMoons)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                planetDetailViewModel.planetState.collect{state ->
                    if (state.loading){
                        planetName.visibility = TextView.GONE
                        planetType.visibility = TextView.GONE
                        planetDescription.visibility = TextView.GONE
                        planetImage.visibility = ImageView.GONE
                        planetMass.visibility = TextView.GONE
                        planetDiameter.visibility = TextView.GONE
                        planetGravity.visibility = TextView.GONE
                        planetRotation.visibility = TextView.GONE
                        planetTraslation.visibility = TextView.GONE
                        planetDistance.visibility = TextView.GONE
                        planetMoons.visibility = TextView.GONE
                    }
                    else{
                        planetName.visibility = TextView.VISIBLE
                        planetType.visibility = TextView.VISIBLE
                        planetDescription.visibility = TextView.VISIBLE
                        planetImage.visibility = ImageView.VISIBLE
                        planetMass.visibility = TextView.VISIBLE
                        planetDiameter.visibility = TextView.VISIBLE
                        planetGravity.visibility = TextView.VISIBLE
                        planetRotation.visibility = TextView.VISIBLE
                        planetTraslation.visibility = TextView.VISIBLE
                        planetDistance.visibility = TextView.VISIBLE
                        planetMoons.visibility = TextView.VISIBLE
                    }

                    if (state.data != null){
                        planetName.text = state.data.name
                        planetType.text = state.data.type
                        planetDescription.text = state.data.description
                        planetMass.text = state.data.mass
                        planetDiameter.text = state.data.diameter
                        planetGravity.text = state.data.gravity
                        planetRotation.text = state.data.rotation
                        planetTraslation.text = state.data.traslation
                        planetDistance.text = state.data.distance
                        planetMoons.text = state.data.moons
                        Picasso.get().load(state.data.image).into(planetImage)
                    }
                }
            }
        }

    }

}