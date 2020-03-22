package com.vladgrushevoy.testindus.fragments

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vladgrushevoy.testindus.viewmodels.DeezerViewModel

abstract class BaseFragment : Fragment() {
    protected val viewModel by lazy {
        ViewModelProvider(this).get(DeezerViewModel::class.java)
    }
}