package com.kgg.android.c79

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : JobService() {

    override fun onCreate() {
        super.onCreate()
        Log.d("kkang", "MyService...onCreate...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("kkang", "MyService...onDestroy...")

    }

    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.d("kkang", "MyService...onStartJob...")

        return false
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("kkang", "MyService...onStopJob...")

        return false
    }
}