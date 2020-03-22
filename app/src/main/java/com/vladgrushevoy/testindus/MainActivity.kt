package com.vladgrushevoy.testindus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vladgrushevoy.testindus.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment())
            .commit()
    }
}
