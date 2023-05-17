package com.example.ipharm

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    var productList = ArrayList<Products>()


    private lateinit var mListener : onItemCickListener


    interface onItemCickListener{
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener (listener: onItemCickListener) {

        mListener = listener

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.product_card,
            parent,false
        )
        return MyViewHolder(itemView, mListener)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = productList[position]

        // Load and display the image using Glide
        Glide.with(holder.itemView)
            .load(currentitem.imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.logo_ipharm)
            .into(holder.imageURL)
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




    class  MyViewHolder(itemView : View, listener: onItemCickListener) : RecyclerView.ViewHolder(itemView){


        val imageURL : ImageView = itemView.findViewById(R.id.img_product)
        val title : TextView = itemView.findViewById(R.id.tV_producttitle)
        val price : TextView = itemView.findViewById(R.id.tV_productprice)

        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)

            }

        }

    }

}
