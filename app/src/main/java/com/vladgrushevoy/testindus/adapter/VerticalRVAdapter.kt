package com.vladgrushevoy.testindus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vladgrushevoy.testindus.R
import com.vladgrushevoy.testindus.models.VerticalModel

class VerticalRVAdapter(var context: Context, private var arrayList: MutableList<VerticalModel>) :
    RecyclerView.Adapter<VerticalRVAdapter.VerticalRVViewHolder>() {

    inner class VerticalRVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclervewparent)
        val title: TextView = itemView.findViewById(R.id.title)
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
        val horizontalRVAdapter = HorizontalRVAdapter(context, verticalModel)
        holder.apply {
            title.text = verticalModel.title
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = horizontalRVAdapter
        }
    }
}