package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.LightStatus
import com.example.myapplication.web.WebClient
import kotlinx.coroutines.launch

class LightFragment : Fragment() {
   private var lightState = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnsleep = view.findViewById<Button>(R.id.btnsleep)
        btnsleep.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, LightFragmentSleep())?.addToBackStack(null)?.commit()
        }

        val btnback = view.findViewById<Button>(R.id.btnBack)
        btnback.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, MainFragment())?.addToBackStack(null)?.commit()
        }

        val btnauto = view.findViewById<Button>(R.id.btnauto)
        btnauto.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, LightAutoFragment())?.addToBackStack(null)?.commit()
        }
        val btnLight = view.findViewById<Button>(R.id.btnLight)
        btnLight.setOnClickListener{
            lightState = !lightState
            if(lightState){
                btnLight.text = "Включен"
            }else{
                btnLight.text = "Выключен"
            }
            setLight(lightState)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_light, container, false)
    }

    fun setLight(b: Boolean){
        lifecycleScope.launch{
            WebClient.setLightState(LightStatus(b, 0, 0))
        }
    }
}


