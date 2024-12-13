package com.example.integradora_android_4a.model

data class Route(
    val userId: String = "",
    val locations: List<LocationData> = emptyList()
)