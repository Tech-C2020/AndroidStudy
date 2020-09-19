package com.example.teacher.androidstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.teacher.androidstudy.db.UserHelper
import com.example.teacher.androidstudy.db.dto.UserDto

class ListSampleActivity : AppCompatActivity() {

    private var userHelper: UserHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_sample)

        userHelper = UserHelper(this)

        // DBからデータを取得
        val userList = userHelper?.select()

        val list = findViewById<ListView>(R.id.user_list_view)
        val adapter = UserAdapter()
        userList?.let {
            adapter.addAll(userList)
        }
        // adapterをlistにバインド
        list.adapter = adapter

        // リストのアイテムクリックイベント
        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val userDto = userList?.get(position) as UserDto
            Toast.makeText(this, userDto.name, Toast.LENGTH_LONG).show()
        }
    }

    inner class UserAdapter : BaseAdapter() {

        private var userDtoList: MutableList<UserDto> = ArrayList<UserDto>()

        override fun getView(position: Int, convertView: View?, container: ViewGroup?): View? {
            var convertView: View? = convertView
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.list_item, container, false)
            }

            Log.i("list_test_log", userDtoList[position].name)

            // nameをバインド
            convertView?.findViewById<TextView>(R.id.name_text_view)?.text =
                userDtoList[position].name

            return convertView
        }

        fun clear() {
            userDtoList.clear()
            notifyDataSetChanged()
        }

        fun addAll(list: List<UserDto>) {
            userDtoList.addAll(0, list)
            notifyDataSetChanged()
        }

        override fun getItem(position: Int): Any {
            return userDtoList[position]
        }

        override fun getItemId(position: Int): Long {
            return userDtoList[position].id.toLong()
        }

        override fun getCount(): Int {
            return userDtoList.size
        }
    }
}