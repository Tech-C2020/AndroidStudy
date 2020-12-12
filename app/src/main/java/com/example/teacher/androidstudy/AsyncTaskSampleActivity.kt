package com.example.teacher.androidstudy

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.AdapterView
import android.widget.SimpleAdapter
import android.widget.Toast
import com.example.teacher.androidstudy.databinding.ActivityAsyncTaskSampleBinding
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class AsyncTaskSampleActivity : AppCompatActivity() {
    lateinit var binding : ActivityAsyncTaskSampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_async_task_sample
        )

        val list: MutableList<MutableMap<String,String>> = mutableListOf()
        list.add(mutableMapOf("name" to "東京", "code" to "tokyo"))
        list.add(mutableMapOf("name" to "大阪", "code" to "osaka"))
        list.add(mutableMapOf("name" to "北海道", "code" to "hokkaido"))
        list.add(mutableMapOf("name" to "ロンドン", "code" to "london"))
        val adapter = SimpleAdapter(
            this,
            list,
            android.R.layout.simple_expandable_list_item_1,
            arrayOf("name"),
            intArrayOf(android.R.id.text1)
        )
        binding.list.adapter = adapter
        binding.list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val item = list[position] as Map<String,String>
            Toast.makeText(this, item["name"], Toast.LENGTH_LONG).show()

            // サーバにアクセス（非同期）
            val task = ApiAccessTask()
            task.execute(item["code"])
        }

    }

    inner class ApiAccessTask : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg parameter: String): String {
            // バックグラウンド処理

            val city = parameter[0]
            val key = "ceff3b2e890360919f60d36c21512312" // apiキー

            // apiをサーバに投げる
            val url = URL("http://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${key}")
            val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "GET" // データの取得のみのためリクエストはget
            val reader = BufferedReader(InputStreamReader(urlConnection.inputStream,"UTF-8"))
            val builder = StringBuilder() // パフォーマンスが高い文字列のビルダー
            try {
                var line = reader.readLine()
                while (line != null) {
                    builder.append(line)
                    line = reader.readLine()
                }
            } finally {
                reader.close()
                urlConnection.disconnect()
            }

            return builder.toString()
        }

        override fun onPostExecute(result: String) {
            // UIスレッド
            val root = JSONObject(result)
            Log.i("tag", root.toString(4))

            val weathers = root.getJSONArray("weather")
            val weather = weathers.getJSONObject(0)
            val main = weather.getString("main")

            // 画面に描画
            binding.text.text = main
        }
    }

}