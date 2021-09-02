package com.example.myapplication.todo

import com.google.gson.annotations.SerializedName

data class Get_Todo(
    var studyId: Long,
    var content: String,
    var status: Boolean
)

class Check_Get_Todo(
    @SerializedName("studyList")
    val checkRoomList22: List<Get_Todo>
)

data class Post_Todo(
    var studyId: Long,
    var content: String,
    var status: Boolean
)

data class Patch_Todo(
    var studyId: Long,
    var content: String
)

data class Put_Todo(
    var studyId: Long,
    var status: Boolean
)

data class Delete_Todo(
    var studyId: Long,
    var content: String,
    var status: Boolean
)
