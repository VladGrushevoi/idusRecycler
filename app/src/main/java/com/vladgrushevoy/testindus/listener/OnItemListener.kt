package com.vladgrushevoy.testindus.listener

import com.vladgrushevoy.testindus.models.IAlbum
import com.vladgrushevoy.testindus.models.ITrack

interface OnItemListener {
    fun onClickItem(response: ITrack)

    fun onClickItem(response: IAlbum)
}