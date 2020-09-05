package com.example.teacher.androidstudy.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CreateHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {

        // テーブルを作る（今後あらたなテーブルを作る場合はここに追加）

        // ユーザ情報を格納するテーブルを作る
        db.execSQL(UserHelper.SQL_CREATE_ENTRIES)

        // A - B

    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Study.db"
    }
}