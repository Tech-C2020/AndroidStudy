package com.example.teacher.androidstudy.handler

import android.util.Log
import android.view.View
import android.widget.Toast

class TestHandler {
    fun handleButton(view : View, value: Int){
        Log.i("testhandler", view.tag.toString())
        //Toast.makeText(this,view.tag.toString(),Toast.LENGTH_LONG)
    }
}