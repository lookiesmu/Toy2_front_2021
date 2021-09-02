package com.example.myapplication.todo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class planAdapter(
    val plan_list: planlist
) : RecyclerView.Adapter<planAdapter.ViewHolder>() {

    inner class ViewHolder(todo_view: View) : RecyclerView.ViewHolder(todo_view) {
        val planContent: TextView
        val todoIsDone: CheckBox

        init {
            planContent = todo_view.findViewById(R.id.plan_content)
            todoIsDone = todo_view.findViewById(R.id.check_box)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_view, parent, false)
        return ViewHolder(view)
    }

    public override fun getItemCount(): Int {
        val sum: Int = plan_list.Planlist.size
        Log.d("sum", "" + sum)

        return plan_list.Planlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val todo = plan_list.Planlist[position]

        holder.planContent.text = todo.content

        holder.todoIsDone.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                cnt++
                Log.d("state", "" + cnt)

            } else {
                cnt--
                Log.d("state--", "" + cnt)
            }
        }
    }

}