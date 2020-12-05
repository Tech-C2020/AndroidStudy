package com.example.teacher.androidstudy

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.widget.Toast
import java.util.*

class StartService : Service() {

    var timer = Timer()
    var timeCount = 0
    val timerTask = object :TimerTask(){
        override fun run() {
            timeCount += 5

            // uiスレッドに渡すパラメータを指定
            val msg = Message()
            msg.arg1 = timeCount
            handler.sendMessage(msg)

            if(timeCount == 30){ // 30秒かどうか
                // サービスを強制終了
                stopSelf()
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        // サービス起動
        Toast.makeText(applicationContext,"service : onCreate", Toast.LENGTH_LONG).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // サービス開始
        Toast.makeText(applicationContext,"service : onStartCommand", Toast.LENGTH_LONG).show()
        timer.schedule(timerTask,5000,5000)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        // サービスを終了
        Toast.makeText(applicationContext,"service : onDestroy", Toast.LENGTH_LONG).show()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    val handler = @SuppressLint("HandlerLeak")
    object : Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            val timeCount = msg?.arg1 ?: 0
            Toast.makeText(applicationContext,timeCount.toString(), Toast.LENGTH_LONG).show()
        }
    }

}
