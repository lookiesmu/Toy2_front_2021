package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import androidx.fragment.app.Fragment


class friend_main : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_friend_main, container, false ) as ViewGroup

        val friend_add_button: ImageView = rootView.findViewById(R.id.friend_add_button) as ImageView
        val friend_recyclerView: ListView = rootView.findViewById(R.id.friend_list_recyclerView) as ListView


        //친구 추가 버튼 누르면 추가화면으로 이동
        friend_add_button.setOnClickListener {
            activity?.let {
                val intent = Intent(context, Friend_add::class.java)
                startActivity(intent)
            }
        }

        return rootView
    }
}