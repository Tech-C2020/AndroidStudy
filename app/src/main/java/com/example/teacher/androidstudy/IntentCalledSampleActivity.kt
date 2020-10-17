package com.example.teacher.androidstudy

import android.app.Activity
import android.app.DownloadManager
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.teacher.androidstudy.databinding.ActivityIntentCalledSampleBinding

class IntentCalledSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_intent_called_sample)

        var binding = DataBindingUtil.setContentView<ActivityIntentCalledSampleBinding>(
            this,
            R.layout.activity_intent_called_sample
        )

        // 呼び出し元の情報を取得
        intent?.extras?.let {
            val value = it.getString(EXTRA_KEY_STRING)
            Toast.makeText(this, value?.toString(), Toast.LENGTH_LONG).show()
        }

        binding.testDo.setOnClickListener {
            val intent = Intent()
            // 呼び出し元に返す値を設定
            intent.putExtra(EXTRA_KEY_STRING,binding.callBackText.text)
            // 呼び出し元に値を返す、問題がない場合はRESULT_OKにする
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    companion object{
        var EXTRA_KEY_STRING = "extra_key_string"
        var CALL_BACK_REQUEST_CODE = 1
    }
}