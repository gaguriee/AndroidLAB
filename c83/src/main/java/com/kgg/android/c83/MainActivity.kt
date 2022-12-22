package com.kgg.android.c83


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment)
            .getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        googleMap = p0
        val latLng = LatLng(37.566610, 126.978403)
        val position = CameraPosition.Builder()
            .target(latLng)
            .zoom(16f)
            .build()
        googleMap?.moveCamera(CameraUpdateFactory.newCameraPosition(position))

        googleMap?.setOnMapClickListener(object :GoogleMap.OnMapClickListener {
            override fun onMapClick(latlng :LatLng) {
                val location = LatLng(latlng.latitude,latlng.longitude)
                Log.d("loc???", latlng.latitude.toString()+" "+latlng.longitude)


                googleMap?.addMarker(MarkerOptions().position(location))
            }
        })

    }

}