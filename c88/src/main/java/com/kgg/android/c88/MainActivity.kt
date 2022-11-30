package com.kgg.android.c88

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.resultView)

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Golde33443.jpg/560px-Golde33443.jpg")
            .ovverride(200, 200)
            .placeholder(R.drawable.loading)
            .error(R.drawable.error)
            .into(imageView)
    }
}