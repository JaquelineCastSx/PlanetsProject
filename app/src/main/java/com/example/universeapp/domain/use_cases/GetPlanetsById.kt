package com.example.universeapp.domain.use_cases

import com.example.universeapp.data.PlanetService
import com.example.universeapp.domain.models.Planet
import com.example.universeapp.presentation.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPlanetsById(private val planetService: PlanetService) {
    operator fun invoke(id: String) : Flow<ApiResult<Planet>> = flow {
        try {
            emit(ApiResult.Loading("Cargando"))
            val response = planetService.getPlanetById(id)
            emit(ApiResult.Success(response))
        } catch (e: Exception) {
            emit(ApiResult.Error(message = "Peticion fallida", data = null))
        }
    }
}