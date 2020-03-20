package com.vladgrushevoy.testindus.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vladgrushevoy.testindus.Models.HorizantalModel
import com.vladgrushevoy.testindus.Models.VerticalModel
import com.vladgrushevoy.testindus.R

class VerticalRVAdapter(private var context: Context, private var arrayList: List<VerticalModel>) : RecyclerView.Adapter<VerticalRVAdapter.VerticalRVViewHolder>(){

    inner class VerticalRVViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView = itemView.findViewById(R.id.recyclervewparent)
        var tilte: TextView = itemView.findViewById(R.id.title)

        var btnMore: Button = itemView.findViewById(R.id.btnMore)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalRVViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical,parent,false)
        return VerticalRVViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: VerticalRVViewHolder, position: Int) {
        val verticalModel: VerticalModel= arrayList[position]
        val title = verticalModel.title
        val singleItem: List<HorizantalModel> = verticalModel.arrayList

        holder.tilte.text = title
        val horizontalRVAdapter = HorizontalRVAdapter(context, singleItem)
        holder.recyclerView.setHasFixedSize(true)
        holder.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        holder.recyclerView.adapter = horizontalRVAdapter
        holder.btnMore.setOnClickListener {
            Toast.makeText(context, verticalModel.title, Toast.LENGTH_SHORT).show()
        }
    }

}