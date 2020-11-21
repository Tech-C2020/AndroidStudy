package com.example.teacher.androidstudy

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.teacher.androidstudy.databinding.ActivityBindSampleBinding
import com.example.teacher.androidstudy.handler.TestHandler

class BindSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityBindSampleBinding>(
            this,
            R.layout.activity_bind_sample
        )

       binding.handler = TestHandler()

    }

}