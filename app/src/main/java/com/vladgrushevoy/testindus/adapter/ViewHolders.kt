package com.vladgrushevoy.testindus.adapter

import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.*
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.vladgrushevoy.testindus.R
import com.vladgrushevoy.testindus.listener.OnItemListener
import com.vladgrushevoy.testindus.models.AlbumChartData
import com.vladgrushevoy.testindus.models.ChartTracksData

class ChartTrackViewHolder(itemView: View) :
    BaseViewHolder(itemView) {
    var textViewTitle: TextView = itemView.findViewById(R.id.txtTitleHorizontal)
    var imageViewThumb: ImageView = itemView.findViewById(R.id.ivThumb)

    override fun bind(response: Any, clickListener: OnItemListener) {
        val horizontalModel = (response as ChartTracksData).data[adapterPosition]
        horizontalModel.apply {
            textViewTitle.text = title
            Picasso.get().load(this.artist.picture_url).into(imageViewThumb)
        }
        itemView.setOnClickListener {
            clickListener.onClickItem(horizontalModel)
        }
    }
}

class ChartAlbumViewHolder(itemView: View) :
    BaseViewHolder(itemView) {
    var textViewTitle: TextView = itemView.findViewById(R.id.txtTitleHorizontal)
    var imageViewThumb: ImageView = itemView.findViewById(R.id.ivThumb)

    override fun bind(response: Any, clickListener: OnItemListener) {
        val horizontalModel = (response as AlbumChartData).data[adapterPosition]
        horizontalModel.apply {
            textViewTitle.text = title
            Picasso.get().load(cover_url).into(imageViewThumb)
        }
        itemView.setOnClickListener {
            clickListener.onClickItem(horizontalModel)
        }
    }
}