package com.vladgrushevoy.testindus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.vladgrushevoy.testindus.R
import com.vladgrushevoy.testindus.models.*

class HorizontalRVAdapter(
    private var context: Context,
    private var verticalModel: VerticalModel
) :
    Adapter<HorizontalRVAdapter.HorizontalRVViewHolder>() {
    private val adapter by lazy { verticalModel.item.data }

    inner class HorizontalRVViewHolder(itemView: View) : ViewHolder(itemView) {
        var textViewTitle: TextView = itemView.findViewById(R.id.txtTitleHorizontal)
        var imageViewThumb: ImageView = itemView.findViewById(R.id.ivThumb)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalRVViewHolder {
        var view: HorizontalRVViewHolder? = null
        when (viewType) {
            TYPE_CHART_TRACKS -> {
                view = HorizontalRVViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_horizontal,
                        parent,
                        false
                    )
                )
            }
            TYPE_CHART_ALBUMS -> {
                view = HorizontalRVViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_horizontal,
                        parent,
                        false
                    )
                )
            }
        }

        return view!!
    }

    override fun getItemCount(): Int {
        return adapter.size
    }

    override fun getItemViewType(position: Int): Int {
        if (verticalModel.item is ChartTracksData) {
            return TYPE_CHART_TRACKS
        } else if (verticalModel.item is AlbumChartData) {
            return TYPE_CHART_ALBUMS
        }
        return -1
    }

    override fun onBindViewHolder(holder: HorizontalRVViewHolder, position: Int) {
        when (holder.itemViewType) {
            TYPE_CHART_TRACKS -> {
                val horizontalModel = adapter[position] as ChartTrack
                holder.textViewTitle.text = horizontalModel.title
                holder.imageViewThumb.setOnClickListener {
                    Toast.makeText(context, horizontalModel.preview, Toast.LENGTH_SHORT).show()
                }
            }
            TYPE_CHART_ALBUMS -> {
                val horizontalModel = adapter[position] as ChartAlbum
                holder.textViewTitle.text = horizontalModel.title
                holder.imageViewThumb.setOnClickListener {
                    Toast.makeText(context, horizontalModel.trackList_url, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        const val TYPE_CHART_TRACKS = 1
        const val TYPE_CHART_ALBUMS = 2
    }
}