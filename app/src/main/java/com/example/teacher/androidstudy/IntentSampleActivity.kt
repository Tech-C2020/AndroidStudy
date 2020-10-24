package com.example.teacher.androidstudy

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
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

        // 明示的インテント（A→Bに遷移して値を渡す）
        binding.test1.setOnClickListener {
            val intent = Intent(this, IntentCalledSampleActivity::class.java)
            // 遷移先に値を渡す
            intent.putExtra(
                IntentCalledSampleActivity.EXTRA_KEY_STRING,
                "hello world"
            )
            startActivity(intent) // インテントを実行
        }

        // 明示的インテント（A→B→AにBからAに値を戻す）
        binding.test2.setOnClickListener {
            val intent = Intent(this, IntentCalledSampleActivity::class.java)
            startActivityForResult(intent, IntentCalledSampleActivity.CALL_BACK_REQUEST_CODE)
        }

        // 暗黙的インテント(電話アプリを立ち上げ)
        binding.test3.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:08012345678")
            }
            startActivity(intent)
        }

        // 暗黙的インテント(アラームアプリを立ち上げ)
        binding.test4.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "test-alerm")
                putExtra(AlarmClock.EXTRA_HOUR, 13)
                putExtra(AlarmClock.EXTRA_MINUTES, 4)
            }
            startActivity(intent)
        }

        // 暗黙的インテント(タイマーアプリを立ち上げ)
        binding.test5.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "test-timer")
                putExtra(AlarmClock.EXTRA_LENGTH, 10)
                //putExtra(AlarmClock.EXTRA_SKIP_UI, true)
            }
            startActivity(intent)
        }
    }

    // 他の画面から戻った時に発動する
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // resultCodeはok or cancel
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == IntentCalledSampleActivity.CALL_BACK_REQUEST_CODE) {
                data?.let {
                    val value = it.extras.get(IntentCalledSampleActivity.EXTRA_KEY_STRING)
                    Toast.makeText(this, value.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}