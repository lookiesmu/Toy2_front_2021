package com.example.myapplication.todo

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_todo_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

var cnt: Int = 0
//달성률을 위한 카운트

class Todo_main : AppCompatActivity() {
    val api_todo = APIS_todo.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_main)

        val date: LocalDate = LocalDate.now()
        val todaydate: String = date.toString()
        today_date.setText(todaydate)


        val planList: planlist = planlist()

        val mAdapter = planAdapter(planList)
        val manager = LinearLayoutManager(this)
        manager.reverseLayout = false
        manager.stackFromEnd = false
        list_todo.layoutManager = manager

        list_todo.adapter = mAdapter

        api_todo.get_todo().enqueue(object : retrofit2.Callback<Check_Get_Todo> {
            override fun onResponse(
                call: Call<Check_Get_Todo>,
                response: Response<Check_Get_Todo>
            ) {
                Log.d("loggg", response.toString())


                if (response.isSuccessful) {
                    for (i in response.body()!!.checkRoomList22.indices) {
                        val content = response.body()!!.checkRoomList22[i].content
                        val status = response.body()!!.checkRoomList22[i].status
                        Log.d("loggg", content)

                        planList.addPlan(
                            plan(
                                content,
                                status
                            )
                        )
                    }
                }
                list_todo.adapter = mAdapter
            }

            override fun onFailure(call: Call<Check_Get_Todo>, t: Throwable) {
                Log.d("loggg", t.message.toString())
                Log.d("loggg", "get_fail")
            }
        })


        add_button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.add_dialong_view, null)
            val dialogtext = dialogView.findViewById<EditText>(R.id.edit_content)


            builder.setView(dialogView)
                .setPositiveButton("add") { dialogInterface, i ->
                    var text = dialogtext.text.toString()
                    planList.addPlan(
                        plan(
                            text
                        )
                    )
                }
                .setNegativeButton("cancel") { dialogInterface, i ->
                }
                .show()

            val size = planList.Planlist.size
            val params = todo_class(size.toString())
            api_todo.post_todo(params).enqueue(object : Callback<Post_Todo> {
                override fun onResponse(call: Call<Post_Todo>, response: Response<Post_Todo>) {
                    if (response.isSuccessful) {
                        val planee = response.body()
                        Log.d("loggg", "post" + planee?.content)
                    }
                }

                override fun onFailure(call: Call<Post_Todo>, t: Throwable) {
                    Log.d("loggg", t.message.toString())
                    Log.d("loggg", "post_fail")
                }
            })
        }
    }

}
