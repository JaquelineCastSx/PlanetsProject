package com.example.universeapp.presentation.states

import com.example.universeapp.domain.models.Planet

data class PlanetState(
    val loading: Boolean = false,
    val data: Planet? = null,
    val error: String = ""
)
