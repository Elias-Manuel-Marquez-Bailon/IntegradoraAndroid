package com.example.integradora_android_4a.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.integradora_android_4a.R
import com.example.integradora_android_4a.model.Route
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RouteListActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route_list)

        listView = findViewById(R.id.routeListView)
        database = FirebaseDatabase.getInstance().getReference("routes")

        loadRoutes()
    }

    private fun loadRoutes() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val routes = mutableListOf<String>()

                snapshot.children.forEach { routeSnapshot ->
                    val route = routeSnapshot.getValue(Route::class.java)
                    route?.let {
                        routes.add("Route by ${it.userId} - ${it.locations.size} points")
                    }
                }

                val adapter = ArrayAdapter(
                    this@RouteListActivity,
                    android.R.layout.simple_list_item_1,
                    routes
                )
                listView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@RouteListActivity, "Failed to load routes", Toast.LENGTH_SHORT).show()
            }
        })
    }
}