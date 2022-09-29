package com.kgg.android.c34

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.auto)

        val datas = resources.getStringArray(R.array.language)
    }
}