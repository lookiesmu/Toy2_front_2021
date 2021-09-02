package com.example.myapplication.todo

import java.io.Serializable

class plan(var content: String, var status : Boolean = false) : Serializable{

}

class planlist() {
    val Planlist = ArrayList<plan>()

    fun addPlan(plan: plan) {
        Planlist.add(plan)
    }
}

class todo_class(var content: String) : Serializable{

}