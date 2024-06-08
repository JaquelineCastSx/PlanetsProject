package com.example.universeapp.presentation.states

import com.example.universeapp.domain.models.Planet

data class PlanetsState(
    val loading: Boolean = false,
    val data: List<Planet> = emptyList(),
    val error: String = ""
)
