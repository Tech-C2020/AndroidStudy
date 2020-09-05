package com.example.teacher.androidstudy.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase

open class BaseSQLite(context: Context) {
    var createHelper = CreateHelper(context)
    var sqliteDatabase : SQLiteDatabase? = null

    // 共通処理

    fun beginTransaction(){
        // インスタンス生成
        sqliteDatabase = createHelper.writableDatabase
        // トランザクションを開始
        sqliteDatabase?.beginTransaction()
    }

    fun commit(){
        sqliteDatabase?.setTransactionSuccessful()
    }

    fun endTransaction(){
        sqliteDatabase?.endTransaction()
    }

    fun close(){
        createHelper.close()
        sqliteDatabase?.close()
    }

}