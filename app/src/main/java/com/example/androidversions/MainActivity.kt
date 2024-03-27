package com.example.androidversions

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var versionsArrayList: ArrayList<VersionsOfAndroid>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        myRecyclerView = findViewById(R.id.recycler_view)
        //8 elements each
        val imgArray = arrayOf(R.drawable.android1,R.drawable.android2,R.drawable.android3,R.drawable.android4,R.drawable.android5,R.drawable.android6,R.drawable.android7,R.drawable.android8)
        val nameArray = arrayOf("Android 1.0 Alpha","Android 1.1 Beta","Android 1.5 Cupcake","Android 1.6 Donut","Android 2.0/2.1 Éclair","Android 2.2 Froyo","Android 2.3 GingerBread","Android 3.0/3.1/3.2 Honeycomb")
        val yearArray = arrayOf("2008","2009","2009","2009","2009","2009","2010","2011")
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        versionsArrayList = arrayListOf<VersionsOfAndroid>()
        for(index in imgArray.indices){
            val element = VersionsOfAndroid(imgArray[index],nameArray[index],yearArray[index])
            versionsArrayList.add(element)
        }
        val adapter = MyAdapter(versionsArrayList,this)
        myRecyclerView.adapter = adapter
    }
}