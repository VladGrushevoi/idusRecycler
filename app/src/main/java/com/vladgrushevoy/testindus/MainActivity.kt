package com.vladgrushevoy.testindus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vladgrushevoy.testindus.Adapter.VerticalRVAdapter
import com.vladgrushevoy.testindus.Models.HorizantalModel
import com.vladgrushevoy.testindus.Models.VerticalModel

class MainActivity : AppCompatActivity() {

    lateinit var verticalRecyclerView : RecyclerView
    lateinit var adapter: VerticalRVAdapter
    lateinit var arrayList: List<VerticalModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalRecyclerView = findViewById(R.id.RVParent)
        verticalRecyclerView.setHasFixedSize(true)

        verticalRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)

        adapter = VerticalRVAdapter(this, arrayList)
        verticalRecyclerView.adapter = adapter

        setData()
    }

    private fun setData() {
        for (i in 1..5){
            val verticalModel: VerticalModel = VerticalModel()
            verticalModel.title =  "Tittle: $i"
            val arrayListHorizontal: ArrayList<HorizantalModel> = ArrayList()
            for(i in 1..5){
                val horizontalModel: HorizantalModel = HorizantalModel()
                horizontalModel.description = "Description: $i"
                horizontalModel.name = "Name: $i"

                arrayListHorizontal.add(horizontalModel)
            }
            verticalModel.arrayList = arrayListHorizontal
        }
    }
}
