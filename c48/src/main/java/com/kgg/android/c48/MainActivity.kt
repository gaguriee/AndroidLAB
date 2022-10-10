package com.kgg.android.c48

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    lateinit var startView : ImageView
    lateinit var pauseView : ImageView
    lateinit var textView: TextView

    var isFirst = true

    lateinit var asyncTask : MyAsyncTask

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startView = findViewById(R.id.main_startBtn)
        pauseView = findViewById(R.id.main_pauseBtn)
        textView = findViewById(R.id.main_textView)
        startView.setOnClickListener {
            if(isFirst){
                asyncTask.isRun = true
                asyncTask.execute()
                isFirst = false
            }
            else{
                asyncTask.isRun = true
            }
        }
        pauseView.setOnClickListener {
            asyncTask.isRun = false
        }
        asyncTask = MyAsyncTask()
    }

    inner class MyAsyncTask : AsyncTask<Void?, Int?, String>(){
        var loopFlag = true
        var isRun = false
        override fun doInBackground(vararg p0: Void?): String {
            var count = 10
            while(loopFlag){
                SystemClock.sleep(1000)
                if(isRun){
                    count--
                    publishProgress(count)
                    if(count == 0){
                        loopFlag = false
                    }
                }
            }
            return "FInish!!"
        }

        //publishprogess(count) 가 호출 되었을 때 데이터를 전달받아 화면 업데이트
        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            textView.setText(values[0].toString())
        }

        // 마지막 리턴값 받아서 최종 종료되는 순간
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            textView.setText(result)
        }
    }

}