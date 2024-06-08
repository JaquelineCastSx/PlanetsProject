package com.example.universeapp.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universeapp.domain.use_cases.GetPlanetsById
import com.example.universeapp.presentation.ApiResult
import com.example.universeapp.presentation.states.PlanetState
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlanetDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPlanetUseCase : GetPlanetsById
) : ViewModel() {
    private val planetId = savedStateHandle.get<String>("planetId") ?: ""

    private var planetJob : Job? = null
    private var _planetState = MutableStateFlow(PlanetState())
    val planetState = _planetState.asStateFlow()
    init {
        getPlanet()
    }

    private fun getPlanet(){
        planetJob?.cancel()
        planetJob = getPlanetUseCase(planetId).onEach { result ->
            when(result){
                is ApiResult.Loading -> {
                    _planetState.value = PlanetState(loading = true)
                }
                is ApiResult.Success -> {
                    _planetState.value = PlanetState(data = result.data!! , loading = false)
                }
                is ApiResult.Error -> {
                    _planetState.value = PlanetState(error = result.message ?: "", loading = false)
                }
            }
    }.launchIn(viewModelScope)
    }
}