package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.web.WebClient
import kotlinx.coroutines.launch

class MainFragment : Fragment() {
    var lamp: Boolean = false
    var minLevel: Int = 0
    var maxLevel: Int = 0
    fun update() {
        lifecycleScope.launch {

            val state = WebClient.getLightState()
             lamp = state.state
            minLevel = state.levelMin
            maxLevel = state.levelMax
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}
