package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class BottomNavigation : AppCompatActivity() {

    //각 화면의 프래그먼트를 선언함
    // <todo list 화면 선언할 자리>
    // <home 화면 선언할 자리>
    var Friend_MainActivity: friend_main? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_navigation)

        // <todo list 화면 선언할 자리>
        // <home 화면 선언할 자리>
        Friend_MainActivity = friend_main()

        val bottom_menu = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // <home을 기본값으로 변경해야함>
        //supportFragmentManager.beginTransaction().replace(R.id.main_container, !!).commit()
        //bottom_menu.setSelectedItemId(R.id.)

        bottom_menu.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            //하단 메뉴바 아이콘에 따라 화면 이동
            when (item.itemId) {
//                R.id.todo -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.main_container, Todo_main!!).commit()
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.home -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.main_container, !!).commit()
//                    return@OnNavigationItemSelectedListener true
//                }
                R.id.friend -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, Friend_MainActivity!!).commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

    }
}

