package com.kgg.android.c33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_list)

        val datas: ArrayList<HashMap<String, String>> = ArrayList()

        var map : HashMap<String, String> = HashMap()

        map["name"] = "LG 트윈스"
        map["content"] = "서울, 잠실 야구장"
        datas.add(map)

        map = HashMap()

        map["name"] = "독수리"
        map["content"] = "구리 야구장"
        datas.add(map)

        val adapter = SimpleAdapter(
            this,
            datas,
            android.R.layout.simple_list_item_2,
            arrayOf("name", "content"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        listView.adapter = adapter
    }
}