package com.kgg.android.c25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    var pauseTime = 0L

    lateinit var startButton : Button
    lateinit var stopButton : Button
    lateinit var  chronometer : Chronometer
    lateinit var resetButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)
        resetButton = findViewById(R.id.resetButton)
        chronometer = findViewById(R.id.chronometer)

        startButton.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            chronometer.start()
            stopButton.isEnabled = true
            resetButton.isEnabled = true
            startButton.isEnabled = false
        }

        stopButton.setOnClickListener {
            pauseTime = chronometer.base - SystemClock.elapsedRealtime()
            chronometer.stop()
            stopButton.isEnabled = false
            resetButton.isEnabled = true
            startButton.isEnabled = true
        }

        resetButton.setOnClickListener {
            pauseTime = 0L
            chronometer.base = SystemClock.elapsedRealtime()
            stopButton.isEnabled = false
            resetButton.isEnabled = false
            startButton.isEnabled = true
        }
    }
}