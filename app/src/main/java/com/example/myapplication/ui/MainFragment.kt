package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.data.LightStatus
import com.example.myapplication.data.OpenDoor
import com.example.myapplication.web.WebClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent

class MainFragment : Fragment() {
    var lamp: Boolean = false
    var minLevel: Int = 0
    var maxLevel: Int = 0
    fun update() {
        lifecycleScope.launch {

            val state = WebClient.getLightStatus()
            lamp = state.state
            minLevel = state.level_min
            maxLevel = state.level_max
            Log.d("MainFragment","$minLevel  $maxLevel")
        }
    }
      fun setLight() {
    lifecycleScope.launch{
        WebClient.setLightStatus(LightStatus(true,20,50))
    }
}
    fun setDoorState(){
        lifecycleScope.launch {
            WebClient.setOpenDoorState(OpenDoor(202087, true))
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
        val btnlite = view.findViewById<Button>(R.id.btnlite)
        btnlite.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container,LightFragment())?.commit()

        }
        update()
        //setLight()
        //setDoorState()


    }
}
