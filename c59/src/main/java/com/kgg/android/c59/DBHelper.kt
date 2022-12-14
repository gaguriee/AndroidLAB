package com.kgg.android.c59

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, "testdb", null, 1){

    //자동 콜 되는 추상함수 override
    override fun onCreate(p0: SQLiteDatabase?) {
        val studentSql ="""
            create table tb_member (
            _id integer primary key autoincrement,
            name not null,
            email,
            phone)
        """
        p0?.execSQL(studentSql)
        p0?.execSQL("insert into tb_member (name, email, phone) values ('kkang', 'kkang104@gmail.com', '1111')")
    }

    // drop시키는 용도로 사용
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table tb_student")
        onCreate(p0)
    }
}