package com.example.teacher.androidstudy.viewmodel

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt

class FormViewModel{
    var name = ObservableField<String>()
    var mail = ObservableField<String>()
    var gender = ObservableInt()
    var iphone = ObservableBoolean()
    var android = ObservableBoolean()
}