package com.vladgrushevoy.testindus.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vladgrushevoy.testindus.listener.OnItemListener

abstract class BaseViewHolder(view: View, onItemListener: OnItemListener) :
    RecyclerView.ViewHolder(view) {
    protected val itemListener = view.setOnClickListener {
        onItemListener.onClickItem(adapterPosition)
    }

    abstract fun bind(response: Any)
}