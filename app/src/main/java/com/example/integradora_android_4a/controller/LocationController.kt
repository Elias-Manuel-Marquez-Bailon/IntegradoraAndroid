package com.example.integradora_android_4a.controller

import android.content.Context
import android.location.Location
import com.example.integradora_android_4a.model.LocationRepository
import com.example.integradora_android_4a.model.UserRoute

class LocationController(private val context: Context) {

    private val locationRepository = LocationRepository(context)

    /**
     * Inicia el seguimiento de la ubicación.
     * @param onLocationUpdate Callback que notifica las actualizaciones de ubicación.
     */
    fun startLocationTracking(onLocationUpdate: (Location) -> Unit) {
        locationRepository.startTracking { location ->
            onLocationUpdate(location)
        }
    }

    /**
     * Detiene el seguimiento de la ubicación.
     */
    fun stopLocationTracking() {
        locationRepository.stopTracking()
    }

    /**
     * Guarda una ruta del usuario en el repositorio.
     * @param userRoute Objeto UserRoute que contiene los datos de la ruta.
     */
    fun saveRoute(userRoute: UserRoute) {
        locationRepository.saveRoute(userRoute)
    }

    /**
     * Obtiene las rutas guardadas del usuario.
     * @param onRoutesFetched Callback que recibe la lista de rutas.
     */
    fun fetchSavedRoutes(onRoutesFetched: (List<UserRoute>) -> Unit) {
        locationRepository.getAllRoutes { routes ->
            onRoutesFetched(routes)
        }
    }
}