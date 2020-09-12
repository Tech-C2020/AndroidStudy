package com.example.teacher.androidstudy.viewmodel

import android.databinding.*
import com.example.teacher.androidstudy.BR
import com.example.teacher.androidstudy.R
import com.example.teacher.androidstudy.db.dto.UserDto
import kotlinx.android.synthetic.main.activity_db_sample.view.*

class FormViewModel : BaseObservable() {

    // https://developer.android.com/topic/libraries/data-binding/observability

    // ObservableFieldでDataBindする場合の書き方
    //var name = ObservableField<String>()

    // プロパティーでDataBindする場合の書き方
    @get:Bindable
    var id: String = ""
        set(value){
            field = value //値を都合の良いデータに変更可能
            //notifyChange()
            notifyPropertyChanged(BR.id)
        }
    @get:Bindable
    var name: String = ""
    set(value){
        field = value //値を都合の良いデータに変更可能
        //notifyChange()
        notifyPropertyChanged(BR.name)
    }
    @get:Bindable
    var mail: String = ""
        set(value){
            field = value //値を都合の良いデータに変更可能
            //notifyChange()
            notifyPropertyChanged(BR.mail)
        }
    @get:Bindable
    var gender: Int = R.id.gender_rb1
        set(value){
            field = value //値を都合の良いデータに変更可能
            //notifyChange()
            notifyPropertyChanged(BR.gender)
        }

//    var mail = ObservableField<String>()
//    var gender = ObservableInt()
    var iphone = ObservableBoolean()
    var android = ObservableBoolean()

    fun fromUserDto(userDto:UserDto?){
        id = userDto?.id.toString()
        name = userDto?.name ?: ""
        mail = userDto?.mail ?: ""
        gender = when(userDto?.gender){
            0-> R.id.gender_rb1 // man
            1-> R.id.gender_rb2 // woman
            2-> R.id.gender_rb3 // other
            else -> R.id.gender_rb1
        }
    }
}