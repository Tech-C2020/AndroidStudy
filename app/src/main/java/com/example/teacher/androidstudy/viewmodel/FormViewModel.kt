package com.example.teacher.androidstudy.viewmodel

import android.databinding.*
import com.example.teacher.androidstudy.BR

class FormViewModel : BaseObservable() {

    // https://developer.android.com/topic/libraries/data-binding/observability

    // ObservableFieldでDataBindする場合の書き方
    //var name = ObservableField<String>()

    // プロパティーでDataBindする場合の書き方
    @get:Bindable
    var name: String = ""
    set(value){
        field = value //値を都合の良いデータに変更可能
        //notifyChange()
        notifyPropertyChanged(BR.name)
    }

    var mail = ObservableField<String>()
    var gender = ObservableInt()
    var iphone = ObservableBoolean()
    var android = ObservableBoolean()
}