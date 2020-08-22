package com.example.teacher.androidstudy

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.teacher.androidstudy.databinding.ActivityUiSample2Binding
import com.example.teacher.androidstudy.viewmodel.FromViewModel

class UiSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ui_sample2)


        // databindingする場合のレイアウトとコードの紐づけ
        var binding = DataBindingUtil.setContentView<ActivityUiSample2Binding>(
            this,
            R.layout.activity_ui_sample2)

        // アーキテクト
        // MVC MVP MVVM クリーンアーキテクト オニオンアーキテクト
        // mvvm : model view viewmodel

        // データをデータベースから取得
        var form = FromViewModel()
        form.name = "matsumoto"
        form.mail = "hoge@yahoo.co.jp"

        binding.viewModel = form

        // レイアウトのインスタンスを取得
        val nameEdit = findViewById<EditText>(R.id.name_edit_text)
        //nameEdit.setText(R.string.app_name)
        val emailEdit = findViewById<EditText>(R.id.email_edit_text)
        //emailEdit.setText(R.string.app_name)
    }
}