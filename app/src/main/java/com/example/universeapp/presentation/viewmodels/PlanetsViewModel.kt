package com.example.universeapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universeapp.domain.use_cases.GetPlanets
import com.example.universeapp.presentation.ApiResult
import com.example.universeapp.presentation.states.PlanetsState
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlanetsViewModel @Inject constructor(
    private val getPlanetsUseCase : GetPlanets
) : ViewModel(){
    private var planetsJob : Job? = null
    private var _planetsState = MutableStateFlow(PlanetsState())
    val planetsState = _planetsState.asStateFlow()

    init {
        getPlanets()
    }

    private fun getPlanets(){
        planetsJob?.cancel()
        planetsJob = getPlanetsUseCase().onEach { result ->
            when(result){
                is ApiResult.Loading -> {
                    _planetsState.value = PlanetsState(loading = true)
                }
                is ApiResult.Success -> {
                    _planetsState.value = PlanetsState(data = result.data!!)
                }
                is ApiResult.Error -> {
                    _planetsState.value = PlanetsState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
        }
}