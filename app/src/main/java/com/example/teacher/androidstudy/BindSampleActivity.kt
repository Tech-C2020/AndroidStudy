package com.example.teacher.androidstudy

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.teacher.androidstudy.databinding.ActivityBindSampleBinding
import com.example.teacher.androidstudy.handler.TestHandler
import com.example.teacher.androidstudy.handler.TestListener

class BindSampleActivity : AppCompatActivity(),TestListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityBindSampleBinding>(
            this,
            R.layout.activity_bind_sample
        )

       //binding.handler = TestHandler()
        binding.listener = this;

    }

    override fun handleButton(view: View, value: Int) {
        Log.i("testhandler", value.toString())
    }

}