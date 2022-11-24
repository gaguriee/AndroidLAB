package com.kgg.android.c79

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            var scheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            JobInfo.Builder(1, ComponentName(this, MyService::class.java)).run{
                setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                scheduler?.schedule((build()))
            }
        }
    }
}