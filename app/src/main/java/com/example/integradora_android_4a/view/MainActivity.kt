package com.example.integradora_android_4a.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.integradora_android_4a.R
import com.example.integradora_android_4a.controller.LocationController

class MainActivity : AppCompatActivity() {

    private lateinit var locationController: LocationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationController = LocationController(this)

        // Navegar al mapa al hacer clic en un botón
        findViewById<View>(R.id.btnOpenMap).setOnClickListener {
            startActivity(Intent(this, MapFragment::class.java))
        }

        // Navegar a la lista de rutas
        findViewById<View>(R.id.btnRouteList).setOnClickListener {
            startActivity(Intent(this, RouteListActivity::class.java))
        }
    }
}