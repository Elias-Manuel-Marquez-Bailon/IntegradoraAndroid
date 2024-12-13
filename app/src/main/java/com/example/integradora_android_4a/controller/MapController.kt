package com.example.integradora_android_4a.controller

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class MapController (private val context: Context){
    private val database = FirebaseDatabase.getInstance().getReference("routes")

    fun drawRouteOnMap(userId: String, googleMap: GoogleMap) {
        database.child(userId).addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val latitude = snapshot.child("latitude").getValue(Double::class.java) ?: return
                val longitude = snapshot.child("longitude").getValue(Double::class.java) ?: return

                val position = LatLng(latitude, longitude)
                googleMap.addPolyline(
                    PolylineOptions()
                        .add(position)
                        .width(5f)
                        .color(context.resources.getColor(android.R.color.holo_blue_dark, null))
                )
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        })
    }

}