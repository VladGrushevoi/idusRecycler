package com.vladgrushevoy.testindus.models

data class ChartTracksData(
    override val data: MutableList<ChartTrack>
) : IRecyclerVerticalModel

data class ChartTrack(
    val id: Long,
    val title: String,
    val preview: String,
    val position: Int
)

data class AlbumChartData(
    override val data: MutableList<ChartAlbum>
) : IRecyclerVerticalModel

data class ChartAlbum(
    override val id: Long,
    override val title: String,
    override val cover_url: String,
    override val artist: Artist,
    override val trackList_url: String
) : IAlbum
