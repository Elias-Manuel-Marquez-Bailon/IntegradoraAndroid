package com.example.integradora_android_4a.view

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
