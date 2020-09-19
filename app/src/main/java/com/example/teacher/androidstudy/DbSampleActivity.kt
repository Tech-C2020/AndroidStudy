package com.example.teacher.androidstudy

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.teacher.androidstudy.databinding.ActivityDbSampleBinding
import com.example.teacher.androidstudy.databinding.ActivityUiSample2Binding
import com.example.teacher.androidstudy.db.UserHelper
import com.example.teacher.androidstudy.viewmodel.FormViewModel
import java.lang.Exception
import java.sql.SQLDataException

class DbSampleActivity : AppCompatActivity() {

    private var userHelper: UserHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_db_sample)

        var binding = DataBindingUtil.setContentView<ActivityDbSampleBinding>(
            this,
            R.layout.activity_db_sample
        )
        var viewModel = FormViewModel()

        // データベース作成 create database
        // テーブルを作成 create table
        // ユーザのdtoにデータ保存
        // DBに保存 insert
        // DBの中身を出力 select

        userHelper = UserHelper(this)

        // トランザクションを呼ぶ
        userHelper?.beginTransaction()

        try {
//            // データを追加
//            userHelper?.insert("test1", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test2", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test3", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test4", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test5", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test6", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test7", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test8", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test9", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test10", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test11", "hoge@yahoo.co.jp", 1)
//            userHelper?.insert("test12", "hoge@yahoo.co.jp", 1)
//
//            userHelper?.commit()

            //userHelper?.delete()
            //userHelper?.commit()

            // データの確認
            val userList = userHelper?.select(
                where = "id = ?",
                whereArgs = arrayOf("1")
            ) // ID１をinsert済みなので固定で指定


            if(userList?.size == 0){
                // テストデータを追加
                userHelper?.insert("matsumoto", "hoge@yahoo.co.jp", 1)
            }


            viewModel.fromUserDto(userList?.first { it.id == 1 })
            binding.viewModel = viewModel // viewmodelをバインド

            binding.updateBtn.setOnClickListener {
                try {
                    userHelper?.beginTransaction()

                    userHelper?.update(
                        viewModel.name,
                        viewModel.mail,
                        viewModel.gender,
                        where = "id = ?",
                        whereArgs = arrayOf("1")
                    )

                    userHelper?.commit()
                    Toast.makeText(this, "updated", Toast.LENGTH_LONG).show()
                    finish()

                } catch (e: SQLDataException) {

                } finally {
                    userHelper?.endTransaction()
                    userHelper?.close()
                }
            }

            Toast.makeText(this, (userList?.size ?: 0).toString(), Toast.LENGTH_LONG).show()

        } catch (e: Exception) {
            // error
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
        } finally {
            userHelper?.endTransaction()
            userHelper?.close()
        }

    }
}