package com.example.integradora_android_4a.view

import android.content.Intent
import android.os.Bundle
<<<<<<< HEAD
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.integradora_android_4a.R
import com.example.integradora_android_4a.controller.LocationController

class MainActivity : AppCompatActivity() {

    private lateinit var locationController: LocationController

=======
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.integradora_android_4a.controller.LocationController
import com.example.myroute.R
import com.example.myroute.controller.LocationController
import com.example.myroute.controller.MapController
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.GoogleMap

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var locationController: LocationController
    private lateinit var mapController: MapController

    private lateinit var mapView: MapView
    private lateinit var btnStartTracking: Button
    private lateinit var btnStopTracking: Button
    private lateinit var tvStatus: TextView

    private var googleMap: GoogleMap? = null

>>>>>>> d3b27e812d129f78167a39f1863b4cf3350aa528
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< HEAD
        locationController = LocationController(this)

        // Navegar al mapa al hacer clic en un botón
        findViewById<View>(R.id.btnOpenMap).setOnClickListener {
            startActivity(Intent(this, MapFragment::class.java))
        }

        // Navegar a la lista de rutas
        findViewById<View>(R.id.btnRouteList).setOnClickListener {
            startActivity(Intent(this, RouteListActivity::class.java))
=======
        // Initialize Controllers
        locationController = LocationController(this)
        mapController = MapController(this)

        // Initialize UI Elements
        mapView = findViewById(R.id.mapView)
        btnStartTracking = findViewById(R.id.btnStartTracking)
        btnStopTracking = findViewById(R.id.btnStopTracking)
        tvStatus = findViewById(R.id.tvStatus)

        // Initialize Map
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        // Set Button Listeners
        btnStartTracking.setOnClickListener {
            startTracking()
        }

        btnStopTracking.setOnClickListener {
            stopTracking()
>>>>>>> d3b27e812d129f78167a39f1863b4cf3350aa528
        }
    }

    private fun startTracking() {
        btnStartTracking.isEnabled = false
        btnStopTracking.isEnabled = true
        tvStatus.text = "Status: Tracking..."

        locationController.startLocationUpdates("user123") { location ->
            // Update UI or Map when location changes
            googleMap?.let { map ->
                mapController.drawRouteOnMap("user123", map)
            }
        }
    }

    private fun stopTracking() {
        btnStartTracking.isEnabled = true
        btnStopTracking.isEnabled = false
        tvStatus.text = "Status: Not tracking"

        locationController.stopLocationUpdates()
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
        locationController.stopLocationUpdates()
    }
}
