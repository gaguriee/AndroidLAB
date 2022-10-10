package com.kgg.android.c49

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    val backgroundScope = CoroutineScope(Dispatchers.Default+ Job())
    //연산 작업을 위함, 화면 view 를 건드리진 않음

    lateinit var button : Button
    lateinit var resultView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        resultView = findViewById(R.id.resultView)

        button.setOnClickListener {
            backgroundScope.launch {
                //코루틴 구동

                var sum = 0L
                var time = measureTimeMillis {
                    for(i in 1..2_000_000_000){ //시간이 굉장히 오래 걸릴 것 가정
                        sum += i
                    }
                }

                //결과 값은 maindispatcher한테 의뢰해야함

                withContext(Dispatchers.Main){
                    resultView.text = "sum : $sum"
                }
            }
        }
    }
}