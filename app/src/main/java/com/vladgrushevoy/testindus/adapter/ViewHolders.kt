package com.vladgrushevoy.testindus.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.vladgrushevoy.testindus.R
import com.vladgrushevoy.testindus.listener.OnItemListener
import com.vladgrushevoy.testindus.models.AlbumChartData
import com.vladgrushevoy.testindus.models.ChartTracksData

class ChartTrackViewHolder(itemView: View, onItemListener: OnItemListener) :
    BaseViewHolder(itemView, onItemListener) {
    var textViewTitle: TextView = itemView.findViewById(R.id.txtTitleHorizontal)
    var imageViewThumb: ImageView = itemView.findViewById(R.id.ivThumb)

    override fun bind(response: Any) {
        val horizontalModel = response as ChartTracksData
        horizontalModel.data[adapterPosition].apply {
            textViewTitle.text = title
            Picasso.get().load(this.artist.picture_url).into(imageViewThumb)
            itemListener
        }
    }
}

class ChartAlbumViewHolder(itemView: View, onItemListener: OnItemListener) :
    BaseViewHolder(itemView, onItemListener) {
    var textViewTitle: TextView = itemView.findViewById(R.id.txtTitleHorizontal)
    var imageViewThumb: ImageView = itemView.findViewById(R.id.ivThumb)

    override fun bind(response: Any) {
        val horizontalModel = response as AlbumChartData
        horizontalModel.data[adapterPosition].apply {
            textViewTitle.text = title
            Picasso.get().load(cover_url).into(imageViewThumb)
            itemListener
        }
    }
}