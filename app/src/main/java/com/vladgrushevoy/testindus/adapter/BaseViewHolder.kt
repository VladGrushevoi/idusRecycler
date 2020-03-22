package com.vladgrushevoy.testindus.adapter

import android.view.View
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.vladgrushevoy.testindus.listener.OnItemListener

abstract class BaseViewHolder(view: View) :
    RecyclerView.ViewHolder(view) {

    abstract fun bind(response: Any, clickListener: OnItemListener)
}