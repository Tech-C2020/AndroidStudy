package com.example.teacher.androidstudy.util

import android.content.Context
import android.content.SharedPreferences

object PrefUtil{

    private fun getShredPreference(context: Context) : SharedPreferences{
        return context.getSharedPreferences(
            "preference_file", Context.MODE_PRIVATE)
    }

    fun saveSwitch(context: Context,check : Boolean){
        val preference = getShredPreference(context)
        with (preference.edit()) {
            putBoolean("check", check)
            commit()
        }
    }

    fun loadSwitch(context: Context) :Boolean{
        val preference = getShredPreference(context)
        return preference.getBoolean("check", false)
    }
}