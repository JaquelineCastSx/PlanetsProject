package com.example.universeapp.data

import com.example.universeapp.domain.models.Planet
import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetService {
    @GET("planets")
    suspend fun getPlanets(): List<Planet>

    @GET("planets/{id}")
    suspend fun getPlanetById(@Path("id")id: String) : Planet
}