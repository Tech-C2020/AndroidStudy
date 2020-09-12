package com.example.teacher.androidstudy

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.Toast
import com.example.teacher.androidstudy.databinding.ActivityUiSample2Binding
import com.example.teacher.androidstudy.viewmodel.FormViewModel

class UiSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ui_sample2)


        // databindingする場合のレイアウトとコードの紐づけ
        var binding = DataBindingUtil.setContentView<ActivityUiSample2Binding>(
            this,
            R.layout.activity_ui_sample2
        )

        // アーキテクト
        // MVC MVP MVVM クリーンアーキテクト オニオンアーキテクト
        // mvvm : model view viewmodel

        // データをデータベースから取得
        var form = FormViewModel()
//        form.name = "matsumoto"
//        form.mail = "hoge@yahoo.co.jp"
        binding.viewModel = form

        // テストボタン（適当なユーザの情報を表示）のクリックイベント
        binding.testBtn.setOnClickListener {

            // リアクティブプログラミング
            form.apply {
               // name.set("matsumoto")
                name = "matsumoto"
                mail = "hoge@yahoo.co.jp"
                gender = R.id.gender_rb2
                iphone.set(true)
                android.set(false)
               // name.notifyChange()
            }

//            form.name.set("matsumoto")
//            form.mail = "hoge@yahoo.co.jp"
//            form.gender = 1
//            form.name.notifyChange()

        }


        // saveボタンのクリックイベント
        binding.saveBtn.setOnClickListener {
            Log.i("form name", form.name)

            // ダイアログ
            AlertDialog.Builder(this)
                .setTitle("Save")
                .setMessage("本当に保存しますか？")
                .setPositiveButton("OK"){ dialog, which ->
                    // 本来はここでデータを保存する
                    // サーバに保存 or 端末内に保存(SQLite)
                    finish() // 現在表示しているActivityを閉じる

                    // トースト
                    Toast.makeText(this,"complete", Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("Cancel"){dialog, which ->
                    dialog.cancel()
                }
                .show()
        }

//        // レイアウトのインスタンスを取得
//        val nameEdit = findViewById<EditText>(R.id.name_edit_text)
//        //nameEdit.setText(R.string.app_name)
//        val emailEdit = findViewById<EditText>(R.id.email_edit_text)
//        //emailEdit.setText(R.string.app_name)
    }
}