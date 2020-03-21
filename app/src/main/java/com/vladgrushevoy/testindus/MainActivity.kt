package com.vladgrushevoy.testindus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladgrushevoy.testindus.adapter.VerticalRVAdapter
import com.vladgrushevoy.testindus.models.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapter by lazy { VerticalRVAdapter(this, arrayListVertical) }
    private val arrayListVertical by lazy { mutableListOf<VerticalModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parent_recycler_view.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = this@MainActivity.adapter
        }
        setData()
    }

    private fun setData() {
        arrayListVertical.add(VerticalModel("Chart tracks", setFakeChartTracks()))
        arrayListVertical.add(VerticalModel("Chart albums", setFakeChartAlbums()))
        adapter.notifyDataSetChanged()
    }

    private fun setFakeChartTracks(): ChartTracksData {
        val array = mutableListOf<ChartTrack>()
        for (i in 1..5) {
            array.add(ChartTrack(i.toLong(), "Title $i", "preview_url", i))
        }
        return ChartTracksData(array)
    }

    private fun setFakeChartAlbums(): AlbumChartData {
        val array = mutableListOf<ChartAlbum>()
        for (i in 1..5) {
            array.add(ChartAlbum(i.toLong(), "Title $i", "track_cover_url", Artist(1, "", ""), ""))
        }
        return AlbumChartData(array)
    }
}
