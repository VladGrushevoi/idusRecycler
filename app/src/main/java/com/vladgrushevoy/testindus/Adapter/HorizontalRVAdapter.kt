package com.vladgrushevoy.testindus.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.vladgrushevoy.testindus.Models.HorizantalModel
import com.vladgrushevoy.testindus.R

class HorizontalRVAdapter(private var context: Context,
                          private var arrayList: List<HorizantalModel>
) :
    RecyclerView.Adapter<HorizontalRVAdapter.HorizonlalRVViewHolder>() {

    inner class HorizonlalRVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView = itemView.findViewById(R.id.txtTitleHorizontal)
        var imageViewThumb: ImageView = itemView.findViewById(R.id.ivThumb)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizonlalRVViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal, parent, false)
        return HorizonlalRVViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: HorizonlalRVViewHolder, position: Int) {
        val horizantalModel: HorizantalModel = arrayList.get(position)
        holder.textViewTitle.setText(horizantalModel.name)
        holder.imageViewThumb.setOnClickListener {
            Toast.makeText(context, horizantalModel.name, Toast.LENGTH_SHORT).show()
        }
    }
}