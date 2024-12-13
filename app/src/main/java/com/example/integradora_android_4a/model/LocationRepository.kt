package com.example.integradora_android_4a.model

import android.content.Context
import android.location.Location
import com.example.integradora_android_4a.utils.FirebaseUtils
import com.google.firebase.database.DatabaseReference

class LocationRepository(private val context: Context) {

    private val locationService = LocationService(context)
    private val databaseReference: DatabaseReference = FirebaseUtils.getRoutesReference()

    /**
     * Inicia el seguimiento de la ubicación.
     * @param onLocationUpdate Callback que notifica las actualizaciones de ubicación.
     */
    fun startTracking(onLocationUpdate: (Location) -> Unit) {
        locationService.startTracking { location ->
            onLocationUpdate(location)
        }
    }

    /**
     * Detiene el seguimiento de la ubicación.
     */
    fun stopTracking() {
        locationService.stopTracking()
    }

    /**
     * Guarda una ruta en Firebase.
     * @param userRoute Objeto UserRoute que contiene los datos de la ruta.
     */
    fun saveRoute(userRoute: UserRoute) {
        val routeId = databaseReference.push().key ?: return
        databaseReference.child(routeId).setValue(userRoute)
    }

    /**
     * Recupera todas las rutas del usuario desde Firebase.
     * @param callback Callback que recibe la lista de rutas.
     */
    fun getAllRoutes(callback: (List<UserRoute>) -> Unit) {
        databaseReference.get().addOnSuccessListener { snapshot ->
            val routes = snapshot.children.mapNotNull { it.getValue(UserRoute::class.java) }
            callback(routes)
        }
    }
}
