package com.example.androidversions

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var versionsArrayList:ArrayList<VersionsOfAndroid>,var context:Activity):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var myListener : OnItemClickListener
    interface  OnItemClickListener {
        fun onItemClick(position:Int)
    }
    fun setItemClickListener(listener: OnItemClickListener){
        myListener = listener
    }
    //creates view holder when layout manager fails to find suitable view foreach item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView)
    }

//populates with data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = versionsArrayList[position]
        holder.imgToShow.setImageResource(currentItem.image)
        holder.nameToShow.text = currentItem.name
        holder.yearToShow.text =  currentItem.year

    }
    //returns the total number of views in our data
    override fun getItemCount(): Int {
        return versionsArrayList.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imgToShow: ImageView = itemView.findViewById(R.id.img)
        var nameToShow: TextView = itemView.findViewById(R.id.name)
        var yearToShow: TextView = itemView.findViewById(R.id.year)
    }
}
