package com.vladgrushevoy.testindus.repositories

import com.vladgrushevoy.testindus.builders.ServiceBuilder
import com.vladgrushevoy.testindus.models.AlbumChartData
import com.vladgrushevoy.testindus.models.ChartTracksData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await

class DeezerRepository {
    private val serviceBuilder by lazy { ServiceBuilder.getInstance().buildService() }

//    suspend fun fetchAlbumByName(name: String): AlbumData = withContext(Dispatchers.IO) {
//        serviceBuilder.searchAlbumByName(name).await()
//    }
//
//    suspend fun fetchTrackByName(name: String): TrackData = withContext(Dispatchers.IO) {
//        serviceBuilder.searchTrackByName(name).await()
//    }

    suspend fun fetchTracksByChart(): ChartTracksData = withContext(Dispatchers.IO) {
        serviceBuilder.getTrackByChart().await()
    }

    suspend fun fetchAlbumByChart(): AlbumChartData = withContext(Dispatchers.IO) {
        serviceBuilder.getAlbumByChart().await()
    }

//    suspend fun fetchAlbumDataById(id: Long): Album = withContext(Dispatchers.IO) {
//        serviceBuilder.getAlbumDataById(id).await()
//    }
//
//    suspend fun fetchTrackById(id: Long): Track = withContext(Dispatchers.IO) {
//        serviceBuilder.getTrackById(id).await()
//    }
}
