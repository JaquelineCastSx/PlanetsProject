package com.example.universeapp.domain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.universeapp.R
import com.example.universeapp.domain.models.Planet
import com.squareup.picasso.Picasso

class PlanetsAdapter(
    private val planets: List<Planet>,
    private val onPlanetClick: (Planet) -> Unit
) : RecyclerView.Adapter<PlanetViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.planet_item, parent, false)
        return PlanetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planet = planets[position]
        holder.name.text = planet.name
        holder.type.text = planet.type
        Picasso.get().load(planet.image).into(holder.image)
        holder.itemView.setOnClickListener { onPlanetClick(planet) }
    }

    override fun getItemCount(): Int = planets.size
}

class PlanetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView
    val type: TextView
    val image: ImageView

    init {
        name = view.findViewById(R.id.TVName)
        type = view.findViewById(R.id.TVType)
        image = view.findViewById(R.id.IVPlanet)
    }

}