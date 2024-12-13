package com.example.integradora_android_4a.model

data class UserRoute(
    val routeId: String = "",
    val routeName: String = "",
    val locations: List<LocationPoint> = emptyList(),
    val timestamp: Long = System.currentTimeMillis()
)

/**
 * Modelo para representar un punto de ubicación.
 * @param latitude Latitud del punto.
 * @param longitude Longitud del punto.
 * @param timestamp Fecha y hora del punto.
 */
data class LocationPoint(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val timestamp: Long = System.currentTimeMillis()
)