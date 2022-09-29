package com.kgg.android.c32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_list)

        val datas = resources.getStringArray(R.array.lcations)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            datas
        )
        listView.adapter = adapter
    }
}