package com.vladgrushevoy.testindus.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladgrushevoy.testindus.models.AlbumChartData
import com.vladgrushevoy.testindus.models.ChartTracksData
import com.vladgrushevoy.testindus.repositories.DeezerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DeezerViewModel : ViewModel() {
    val topTrackLiveData by lazy { MutableLiveData<ChartTracksData>() }
    val topAlbumLiveData by lazy { MutableLiveData<AlbumChartData>() }
    private val deezerRepo by lazy { DeezerRepository() }
//    private val getTrackByName by lazy { MutableLiveData<TrackData>() }
//    private val getAlbymById by lazy { MutableLiveData<Album>() }
//    private val getAlbumByName by lazy { MutableLiveData<AlbumData>() }
//    private val getTrackById by lazy { MutableLiveData<Track>() }

    fun getTopTracks() = GlobalScope.launch {
        val response = deezerRepo.fetchTracksByChart()
        withContext(Dispatchers.Main) {
            topTrackLiveData.value = response
        }
    }

    fun getTopAlbums() = GlobalScope.launch {
        val response = deezerRepo.fetchAlbumByChart()
        withContext(Dispatchers.Main) {
            topAlbumLiveData.value = response
        }
    }

//    fun getTrackByName(name: String) = GlobalScope.launch {
//        getTrackByName.value = deezerRepo.fetchTrackByName(name)
//    }
//
//    fun getAlbumById(id: Long) = GlobalScope.launch {
//        getAlbymById.value = deezerRepo.fetchAlbumDataById(id)
//    }
//
//    fun getAlbumByName(name: String) = GlobalScope.launch {
//        getAlbumByName.value = deezerRepo.fetchAlbumByName(name)
//    }
//
//    fun getTrackById(id: Long) = GlobalScope.launch {
//        getTrackById.value = deezerRepo.fetchTrackById(id)
}
