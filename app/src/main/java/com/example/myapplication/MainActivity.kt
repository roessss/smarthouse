package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.R.*
import com.example.myapplication.ui.LightFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        fun navigateTo(fragment: Fragment) {
            supportFragmentManager
                .beginTransaction()
                .replace(id.container, LightFragment())
                .commit()
        }

        fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(layout.activity_main)

            if (savedInstanceState == null) {
                navigateTo(LightFragment())
            }
        }
    }
}

