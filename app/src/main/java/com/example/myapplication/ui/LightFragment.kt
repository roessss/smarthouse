package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class LightFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnsleep = view.findViewById<Button>(R.id.btnsleep)
        btnsleep.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, LightFragmentSleep())?.addToBackStack(null)?.commit()
        }

            val btnauto = view.findViewById<Button>(R.id.btnauto)
            btnauto.setOnClickListener {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container, LightAutoFragment())?.addToBackStack(null)?.commit()
            }


    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_light, container, false)
    }
}


