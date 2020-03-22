package com.vladgrushevoy.testindus.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.vladgrushevoy.testindus.R
import com.vladgrushevoy.testindus.listener.OnItemListener
import com.vladgrushevoy.testindus.models.AlbumChartData
import com.vladgrushevoy.testindus.models.ChartTracksData
import com.vladgrushevoy.testindus.models.IRecyclerHorizontalModel

class HorizontalRVAdapter(
    val item: IRecyclerHorizontalModel,
    private val onItemListener: OnItemListener
) :
    Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: BaseViewHolder? = null
        when (viewType) {
            TYPE_CHART_TRACKS -> {
                view = ChartTrackViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_horizontal,
                        parent,
                        false
                    )
                )
            }
            TYPE_CHART_ALBUMS -> {
                view = ChartAlbumViewHolder(
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
        return item.data.size
    }

    override fun getItemViewType(position: Int): Int {
        if (item is ChartTracksData) {
            return TYPE_CHART_TRACKS
        } else if (item is AlbumChartData) {
            return TYPE_CHART_ALBUMS
        }
        return -1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TYPE_CHART_TRACKS -> {
                (holder as ChartTrackViewHolder).bind(item, onItemListener)
            }
            TYPE_CHART_ALBUMS -> {
                (holder as ChartAlbumViewHolder).bind(item, onItemListener)
            }
        }
    }

    companion object {
        const val TYPE_CHART_TRACKS = 1
        const val TYPE_CHART_ALBUMS = 2
    }
}