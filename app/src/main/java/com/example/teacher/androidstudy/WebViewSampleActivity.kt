package com.example.teacher.androidstudy

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.teacher.androidstudy.databinding.ActivityWebViewSampleBinding

class WebViewSampleActivity : AppCompatActivity() {

    companion object{
        var EXTRA_URL = "extra_url"
        var EXTRA_INTERNAL = "extra_internal"
    }

    lateinit var binding :ActivityWebViewSampleBinding
    var url = ""
    var internal = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_web_view_sample)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_web_view_sample
        )

        // 呼び出し元の情報を取得
        intent?.extras?.let {
            url = it.getString(EXTRA_URL)
            internal = it.getBoolean(EXTRA_INTERNAL)
        }

        binding.webview.webViewClient = MyWebViewClient(this,internal)
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.loadUrl(url)

        // リロード
        //binding.webview.reload()

        // ページを進める
        //binding.webview.goForward()

        // ページを戻す
        // binding.webview.goBack()
    }

    // 端末のなにかしらのボタンを押したときに呼ばれる
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check if the key event was the Back button and if there's history
        // 端末の戻るボタンをおして且つ、履歴がある場合
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webview.canGoBack()) {
            binding.webview.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }

    private class MyWebViewClient(context: Context,internal : Boolean) : WebViewClient() {

        val context = context
        val internal = internal

        // ページを開いたときに呼ばれる
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            Toast.makeText(context,url,Toast.LENGTH_LONG).show()
            return if(internal) {
                false
            }else{
                Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                    startActivity(context,this,null)
                }
                true
            }
        }
    }
}