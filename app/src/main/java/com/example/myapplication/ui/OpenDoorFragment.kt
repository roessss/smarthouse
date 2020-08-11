package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.web.WebClient
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketTimeoutException

class OpenDoorFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_opendoor, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnlog = view.findViewById<Button>(R.id.btnlog)
        btnlog.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, HistoryOpenDoorFragment())?.addToBackStack(null)?.commit()
        }
        val btnOpen = view.findViewById<Button>(R.id.btnOpen)
        btnOpen.setOnClickListener{
           // Snackbar.make(view, "Open the door...", Snackbar.LENGTH_SHORT).show()
            openDoor()
        }
    }

    fun openDoor(){

        lifecycleScope.launch {
            try {
                WebClient.setOpenDoorState()
            }catch (ex: HttpException){
                Toast.makeText(this@OpenDoorFragment.context, "Error ${ex.code()}", Toast.LENGTH_SHORT).show()
            }catch (timeout: SocketTimeoutException){
                Toast.makeText(this@OpenDoorFragment.context, "Timeout!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}