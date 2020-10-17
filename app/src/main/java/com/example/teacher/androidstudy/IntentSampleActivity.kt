package com.example.teacher.androidstudy

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.teacher.androidstudy.IntentCalledSampleActivity.Companion.CALL_BACK_REQUEST_CODE
import com.example.teacher.androidstudy.databinding.ActivityIntentSampleBinding

class IntentSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_intent_sample)

        var binding = DataBindingUtil.setContentView<ActivityIntentSampleBinding>(
            this,
            R.layout.activity_intent_sample
        )

        binding.test1.setOnClickListener {
            val intent = Intent(this,IntentCalledSampleActivity::class.java)
            // 遷移先に値を渡す
            intent.putExtra(
                    IntentCalledSampleActivity.EXTRA_KEY_STRING,
            "hello world")
            startActivity(intent) // インテントを実行
        }

        binding.test2.setOnClickListener {
            val intent = Intent(this,IntentCalledSampleActivity::class.java)
            startActivityForResult(intent,IntentCalledSampleActivity.CALL_BACK_REQUEST_CODE)
        }

        binding.test3.setOnClickListener {

        }
    }

    // 他の画面から戻った時に発動する
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // resultCodeはok or cancel
        if(resultCode == Activity.RESULT_OK) {
            if (requestCode == IntentCalledSampleActivity.CALL_BACK_REQUEST_CODE) {
                data?.let{
                    val value = it.extras.get(IntentCalledSampleActivity.EXTRA_KEY_STRING)
                    Toast.makeText(this,value.toString(),Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}