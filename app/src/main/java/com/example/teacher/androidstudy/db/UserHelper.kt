package com.example.teacher.androidstudy.db

import android.content.ContentValues
import android.content.Context
import com.example.teacher.androidstudy.db.dto.UserDto

class UserHelper(context: Context) : BaseSQLite(context) {

    fun insert(name: String, mail: String, gender: Int) {
        sqliteDatabase?.let {
            val values = ContentValues().apply {
                put(NAME, name)
                put(MAIL, mail)
                put(GENDER, gender)
            }
            it.insert(TABLE, null, values)
        }
        //sqliteDatabase?.execSQL("insert ......") // これでもいいけど
    }

    fun select(where: String? = null, whereArgs: Array<String>? = null): List<UserDto> {
        val database = createHelper.readableDatabase

        // column
        val col = arrayOf(
            ID,
            NAME,
            MAIL,
            GENDER
        )

        // sql 実行
        val cursor = database.query(
            TABLE,
            col,
            where,
            whereArgs,
            null,
            null,
            ID
        )

        // カーソルをリストに変更
        val list = mutableListOf<UserDto>()
        with(cursor) {
            while (moveToNext()) {
                val userDto = UserDto()
                userDto.id = getInt(getColumnIndexOrThrow(ID))
                userDto.name = getString(getColumnIndexOrThrow(NAME))
                userDto.mail = getString(getColumnIndexOrThrow(MAIL))
                userDto.gender = getInt(getColumnIndexOrThrow(GENDER))
                list.add(userDto)
            }
        }

        return list
    }

    fun update(
        name: String? = null,
        mail: String? = null,
        gender: Int? = null,
        where: String? = null,
        whereArgs: Array<String>? = null
    ) {
        sqliteDatabase?.let {
            val values = ContentValues().apply {
                name?.let { put(NAME, name) }
                mail?.let { put(MAIL, mail) }
                gender?.let { put(GENDER, gender) }
            }
            it.update(TABLE, values, where, whereArgs)
        }
    }

    fun delete(where: String? = null, whereArgs: Array<String>? = null) {
        sqliteDatabase?.let {
            it.delete(TABLE, where, whereArgs)
        }
    }

    companion object {
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