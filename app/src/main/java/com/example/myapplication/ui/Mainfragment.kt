package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.web.WebClientMisha
import kotlinx.coroutines.launch
import java.util.*

class MainFragment : Fragment() {
    var temp: Boolean = false
    var min: Int = 0
    var max: Int = 0
    fun update() {
        lifecycleScope.launch {

            val state = WebClientMisha.getClimateData()

            Log.d("MainFragment","!${Arrays.toString(state.history)}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
       // update()



    }
}