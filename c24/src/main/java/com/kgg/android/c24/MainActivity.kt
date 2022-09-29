package com.kgg.android.c24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var  resultView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.resultView)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        var eventType = ""
        when(event?.action){
            MotionEvent.ACTION_DOWN -> eventType = "DOWN EVENT"
            MotionEvent.ACTION_UP -> eventType ="UP EVENT"
            MotionEvent.ACTION_MOVE -> eventType = "MOVE EVENT"
        }
        resultView.text = "$eventType : x - ${event?.x}, y - ${event?.y}"
        return super.onTouchEvent(event)
    }
}