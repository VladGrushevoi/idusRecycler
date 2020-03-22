package com.vladgrushevoy.testindus

import com.vladgrushevoy.testindus.repositories.DeezerRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class TestApi {
    private val deezerRepository by lazy { DeezerRepository() }

    @Test
    fun testFetchAlbumByChart() {
        runBlocking {
            Assert.assertNotNull(deezerRepository.fetchAlbumByChart())
        }
    }

    @Test
    fun testFetchChartTracks() {
        runBlocking {
            Assert.assertNotNull(deezerRepository.fetchTracksByChart())
        }
    }
}
