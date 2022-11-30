package com.kgg.android.c82

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {
    lateinit var resultView: TextView
    lateinit var providerClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.resultView)

        val apiClient = GoogleApiClient.Builder(this)
            .addApi(LocationServices.API)
            .addConnectionCallbacks(connectionCallback)
            .addOnConnectionFailedListener(connectionFailedCallback)
            .build()

        providerClient = LocationServices.getFusedLocationProviderClient(this)

        val launcher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){
            if(it){
                apiClient.connect()
            }else{
                Toast.makeText(this, "denied", Toast.LENGTH_SHORT).show()
            }
        }

        val status = ContextCompat.checkSelfPermission(this,
            "android.permission.ACCESS_FINE_LOCATION")
        if(status == PackageManager.PERMISSION_GRANTED){
            apiClient.connect()
        }else{
            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    val connectionCallback = object: GoogleApiClient.ConnectionCallbacks {
        @SuppressLint("MissingPermission")
        override fun onConnected(p0: Bundle?) {
            providerClient.lastLocation.addOnSuccessListener {
                val latitude = it?.latitude
                val longitude = it?.longitude
                resultView.text = "$latitude, $longitude"
            }
        }

        override fun onConnectionSuspended(p0: Int) {

        }
    }

    private val connectionFailedCallback = object: GoogleApiClient.OnConnectionFailedListener {
        override fun onConnectionFailed(p0: ConnectionResult) {

        }
    }
}