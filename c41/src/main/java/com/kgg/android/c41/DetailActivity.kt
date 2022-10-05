package com.kgg.android.c41

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val id = intent.getIntExtra("id", 0)
        val title = intent.getStringExtra("title")
        val resultView = findViewById<TextView>(R.id.resultView)
        resultView.text = "id: $id, title: $title"
    }
}