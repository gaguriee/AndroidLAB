package com.kgg.android.c93

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kgg.android.c93.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpager.adapter = MyAdapter(this)
    }
}