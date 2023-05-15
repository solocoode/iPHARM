package com.example.ipharm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (private var emplist: ArrayList<products>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tV_producttitle)
        val price: TextView = itemView.findViewById(R.id.tV_productprice)
    }


    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return MyViewHolder(itemView)
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentEmp = emplist[position]
        holder.name.text = currentEmp.title
        holder.price.text = currentEmp.price
    }


    // This method returns the total
    // number of items in the data set
    override fun getItemCount(): Int {
        return emplist.size
    }
}