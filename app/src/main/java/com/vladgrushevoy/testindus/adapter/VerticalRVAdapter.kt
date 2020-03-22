package com.vladgrushevoy.testindus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.vladgrushevoy.testindus.R
import com.vladgrushevoy.testindus.listener.OnItemListener
import com.vladgrushevoy.testindus.models.VerticalModel

class VerticalRVAdapter(
    private val context: Context,
    private val arrayList: MutableList<VerticalModel>,
    private val onItemListener: OnItemListener
) :
    Adapter<VerticalRVAdapter.VerticalRVViewHolder>() {
    private lateinit var horizontalRVAdapter: HorizontalRVAdapter

    inner class VerticalRVViewHolder(itemView: View) : ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.horizontal_recycler_view)
        val title: TextView = itemView.findViewById(R.id.title)
        val itemListener = itemView.setOnClickListener {
            onItemListener.onClickItem(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalRVViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_vertical, parent, false)
        return VerticalRVViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: VerticalRVViewHolder, position: Int) {
        val verticalModel = arrayList[position]
        horizontalRVAdapter = HorizontalRVAdapter(verticalModel.item, onItemListener)
        holder.apply {
            title.text = verticalModel.title
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = horizontalRVAdapter
            itemListener
        }
    }
}