package com.example.universeapp.di

import com.example.universeapp.data.PlanetService
import com.example.universeapp.domain.use_cases.GetPlanets
import com.example.universeapp.domain.use_cases.GetPlanetsById
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val BASE_URL = "https://planets.juanfrausto.com/api/"

    @Provides
    @Singleton
    fun providePlanetService(): PlanetService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlanetService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetPlanetsUseCase(planetService: PlanetService): GetPlanets {
        return GetPlanets(planetService)
    }

    @Provides
    @Singleton
    fun provideGetPlanetsByIdUseCase(planetService: PlanetService): GetPlanetsById {
        return GetPlanetsById(planetService)
    }
}