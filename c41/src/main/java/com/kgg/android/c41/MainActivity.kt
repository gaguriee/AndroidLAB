package com.kgg.android.c41

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_list)

        val datas = arrayOf<String>("android", "kotlin", "jetpack")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            datas
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", i)
            intent.putExtra("title", datas[i])
            startActivity(intent)

        }
    }
}