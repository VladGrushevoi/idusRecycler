package com.vladgrushevoy.testindus.listener

import java.io.Serializable

interface OnItemListener : Serializable {
    fun onClickItem(position: Int)
}