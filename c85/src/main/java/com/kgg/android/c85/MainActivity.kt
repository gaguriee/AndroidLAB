package com.kgg.android.c85

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultView = findViewById<TextView>(R.id.resultView)
        resultView.text = isNetworkAvailable()

    }

    private fun isNetworkAvailable() : String {
        val manager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = manager.activeNetwork ?: return "offline"
            val actNw = manager.getNetworkCapabilities(nw) ?: return "offline"

            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return "wifi online"
                }
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return "cellular online"
                }
                else -> "offline"
            }
        }else{
                if(manager.activeNetworkInfo?.isConnected ?: false){
                    return "online"
                }
                else{
                    return "offline"
                }
            }
        }
    }
