package com.example.teacher.androidstudy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity","onCreate")
        setContentView(R.layout.activity_main) // bindする

        // xmlのviewに関する処理
        val uiBtn = findViewById<Button>(R.id.ui_sample_btn)
        val dbBtn = findViewById<Button>(R.id.db_sample_btn)
        val prefBtn = findViewById<Button>(R.id.pref_sample_btn)
        val listBtn = findViewById<Button>(R.id.list_sample_btn)
        val intentBtn = findViewById<Button>(R.id.intent_sample_btn)
        val fragmentBtn = findViewById<Button>(R.id.fragment_sample_btn)
        val webViewBtn = findViewById<Button>(R.id.webview_sample_btn)
        val bindingBtn = findViewById<Button>(R.id.binding_sample_btn)
        val asyncViewBtn = findViewById<Button>(R.id.async_sample_btn)
        val serviceBtn = findViewById<Button>(R.id.service_sample_btn)
        val asyncTaskViewBtn = findViewById<Button>(R.id.async_task_sample_btn)

        // listenerをsetOnClickListenerメソッドで渡す（レガシー）
//        sampleBtn.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//
//            }
//        })

        // ラムダを使って上の構文を簡略化（条件はメソッドが一つしかないこと）
        uiBtn.setOnClickListener {
            val intent = Intent(this,UiSampleActivity::class.java)
            startActivity(intent) // インテントを実行
        }

        dbBtn.setOnClickListener {
            val intent = Intent(this,DbSampleActivity::class.java)
            startActivity(intent) // インテントを実行
        }

        prefBtn.setOnClickListener {
            val intent = Intent(this,PrefSampleActivity::class.java)
            startActivity(intent) // インテントを実行
        }

        listBtn.setOnClickListener {
            val intent = Intent(this,ListSampleActivity::class.java)
            startActivity(intent) // インテントを実行
        }

        intentBtn.setOnClickListener {
            val intent = Intent(this,IntentSampleActivity::class.java)
            startActivity(intent) // インテントを実行
        }

        fragmentBtn.setOnClickListener {
            val intent = Intent(this,FragmentSampleActivity::class.java)
            startActivity(intent) // インテントを実行
        }

        webViewBtn.setOnClickListener {
            val intent = Intent(this,WebViewSampleActivity::class.java)
            intent.putExtra(WebViewSampleActivity.EXTRA_URL,"https://yahoo.co.jp")
            intent.putExtra(WebViewSampleActivity.EXTRA_INTERNAL, true)
            startActivity(intent) // インテントを実行
        }

        bindingBtn.setOnClickListener {
            val intent = Intent(this,BindSampleActivity::class.java)
            startActivity(intent) // インテントを実行
        }

        asyncViewBtn.setOnClickListener {
            val intent = Intent(this,AsyncSampleActivity::class.java)
            startActivity(intent) // インテントを実行
        }

        serviceBtn.setOnClickListener {
            val intent = Intent(this,StartService::class.java)
            startService(intent)
        }

        asyncTaskViewBtn.setOnClickListener {
            val intent = Intent(this,AsyncTaskSampleActivity::class.java)
            startActivity(intent)
        }
       // sampleBtn.setOnClickListener(UISampleListener())
    }

    inner class UISampleListener :View.OnClickListener{
        override fun onClick(v: View?) {
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","onDestroy")
    }

}
