package com.example.ipharm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val productList = ArrayList<Products>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.product_card,
            parent,false
        )
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = productList[position]

        holder.title.text = currentitem.title
        holder.price.text = currentitem.price

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateproductList(productList : List<Products>){

        this.productList.clear()
        this.productList.addAll(productList)
        notifyDataSetChanged()

    }

    class  MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val title : TextView = itemView.findViewById(R.id.tV_producttitle)
        val price : TextView = itemView.findViewById(R.id.tV_productprice)

    }
}