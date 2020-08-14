package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.LightStatus
import com.example.myapplication.web.WebClient
import kotlinx.coroutines.launch


class LightAutoFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lightauto, container, false)
    }
    private var lightStatus = false
    private var max = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnback = view.findViewById<Button>(R.id.btnBack)
        btnback.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, LightFragment())?.addToBackStack(null)?.commit()
        }
       val btnSave = view.findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener{
            setLightStatus(max)
        }
        val seekBar = view.findViewById<SeekBar>(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                max = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })


    }
    fun setLightStatus(max: Int) {
        lifecycleScope.launch {
            WebClient.setLightState(LightStatus(true, 0, max))
        }
    }
}
