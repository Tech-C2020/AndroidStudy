package com.example.teacher.androidstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import com.example.teacher.androidstudy.util.PrefUtil

class PrefSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pref_sample)

        val switch = findViewById<Switch>(R.id.pref_test_switch)

        switch.isChecked = PrefUtil.loadSwitch(this)
        switch.setOnCheckedChangeListener { _, isChecked ->
            PrefUtil.saveSwitch(this, isChecked)
        }
    }
}