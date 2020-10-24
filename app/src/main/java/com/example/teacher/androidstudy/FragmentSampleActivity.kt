package com.example.teacher.androidstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.teacher.androidstudy.ui.main.FragmentSampleFragment

class FragmentSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_sample_activity)

        // savedInstanceStateは前のインスタンス生成時の情報を保持
        if (savedInstanceState == null) {

            //  FragmentをActivityにバインド
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentSampleFragment.newInstance()) // Fragmentを指定のレイアウトに当てはまる
                .commitNow() // 反映
        }

        Log.i("FragmentSampleActivity","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("FragmentSampleActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("FragmentSampleActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("FragmentSampleActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("FragmentSampleActivity","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("FragmentSampleActivity","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("FragmentSampleActivity","onDestroy")
    }
}