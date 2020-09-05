package com.example.teacher.androidstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.teacher.androidstudy.db.UserHelper
import java.lang.Exception

class DbSampleActivity : AppCompatActivity() {

    private var userHelper: UserHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_sample)

        // データベース作成 create database
        // テーブルを作成 create table
        // ユーザのdtoにデータ保存
        // DBに保存 insert
        // DBの中身を出力 select

        // トランザクションを呼ぶ
        userHelper?.beginTransaction()

        try {
            // データを追加
            userHelper?.insert("matsumoto", "hoge@yahoo.co.jp", 1)
            userHelper?.insert("tanaka", "hoge@yahoo.co.jp", 1)
            userHelper?.insert("suzuki", "hoge@yahoo.co.jp", 1)

            userHelper?.commit()
            Toast.makeText(this,"insert complete", Toast.LENGTH_LONG).show()
        }catch (e : Exception){
            // error
            Toast.makeText(this,"error", Toast.LENGTH_LONG).show()
        }finally {
            userHelper?.endTransaction()
        }

    }
}