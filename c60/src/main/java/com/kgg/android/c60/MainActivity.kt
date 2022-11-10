package com.kgg.android.c60


import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleView = findViewById<EditText>(R.id.add_title)
        val contentView = findViewById<EditText>(R.id.add_content)
        val addBtn = findViewById<Button>(R.id.add_btn)

        addBtn.setOnClickListener {
            val title = titleView.text.toString()
            val content = contentView.text.toString()

            val helper = DBHelper(this)
            val db = helper.writableDatabase
            db.execSQL("insert into tb_memo (title, context) values (?,?)",
                arrayOf(title, content))
            //물음표 2개, 배열사이즈 2개
            db.close()

            val intent = Intent(this, ReadActivity::class.java)
            startActivity(intent)
        }
    }
}