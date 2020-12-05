package com.example.teacher.androidstudy

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import com.example.teacher.androidstudy.databinding.ActivityAsyncSampleBinding
import com.example.teacher.androidstudy.databinding.ActivityDbSampleBinding

class AsyncSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = DataBindingUtil.setContentView<ActivityAsyncSampleBinding>(
            this,
            R.layout.activity_async_sample
        )

        // ui スレッドでuiによる処理を行う
        Toast.makeText(this,"ui thread", Toast.LENGTH_LONG).show()

        Thread(Runnable {
            // worker スレッド(uiに対しての処理ができない)
            Thread.sleep(5000) // なにかしらの重たい処理

            // uiスレッドに渡すパラメータを指定
            val msg = Message()
            msg.arg1 = 1
            msg.arg2 = 2
            msg.obj = "hello"
            handler.sendMessage(msg) // handlerによりuiスレッドに遷移する worker→ui
        }).start()
    }

    val handler = @SuppressLint("HandlerLeak")
    object : Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            Toast.makeText(applicationContext,"worker thread " + msg?.obj , Toast.LENGTH_LONG).show()
        }
    }
}