package com.example.teacher.androidstudy.db

import android.content.ContentValues
import android.content.Context

class UserHelper(context: Context) : BaseSQLite(context) {

    fun insert(name: String,mail : String,gender : Int){
        sqliteDatabase?.let{
            val values = ContentValues().apply {
                put(NAME, name)
                put(MAIL, mail)
                put(GENDER, gender)
            }
            it.insert(TABLE,null,values)
        }
        //sqliteDatabase?.execSQL("insert ......") // これでもいいけど
    }


    companion object{
        const val TABLE = "users"
        const val ID = "id"
        const val NAME = "name"
        const val MAIL = "mail"
        const val GENDER = "gender"

        const val SQL_CREATE_ENTRIES =
            "CREATE TABLE $TABLE (" +
                    "$ID INTEGER PRIMARY KEY," +
                    "$NAME TEXT," +
                    "$MAIL TEXT," +
                    "$GENDER INTEGER)"
    }
}