package com.example.myapplication.ui

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.Log
import com.example.myapplication.data.SecurityLog
import com.example.myapplication.web.WebClient
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_historyopendoor.*
import kotlinx.android.synthetic.main.item_history.*
import kotlinx.android.synthetic.main.item_history.view.*
import kotlinx.coroutines.launch

class HistoryOpenDoorFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_historyopendoor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = Adapter()
        historyView.layoutManager = LinearLayoutManager(requireContext())
        historyView.adapter = adapter

        lifecycleScope.launch{
            val history = WebClient.getDoorLog().Log

            android.util.Log.d("HistoryOpenDoorFragment", history.toString())
            adapter.setNewList(history)
        }

        super.onViewCreated(view, savedInstanceState)
        val btnback = view.findViewById<Button>(R.id.btnBack)
        btnback.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, OpenDoorFragment())?.addToBackStack(null)?.commit()
        }
        getDoorLog()
    }

    fun getDoorLog(){
        lifecycleScope.launch{
            val doorLog = WebClient.getDoorLog()
        }
    }

    class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

        private val list = mutableListOf<Log>()

        fun setNewList(newList: List<Log>){
            list.clear()
            list.addAll(newList)
            notifyDataSetChanged()
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_history, parent,false)

            return ViewHolder(view)

        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          holder.bind(list[position])
        }

        class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),
            LayoutContainer {
            fun bind(item: Log) {
                android.util.Log.d("DomAdapter", item.toString())
                containerView.tvDate.text = item.Date
                containerView.tvOpenDoor.text = item.open_door.toString()
            }

        }
    }
}


