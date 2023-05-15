package com.example.ipharm.ui.home

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipharm.Adapter
import com.example.ipharm.Constants
import com.example.ipharm.R
import com.example.ipharm.databinding.FragmentHomeBinding
import com.example.ipharm.products
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.collections.ArrayList

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var db = Firebase.firestore
    private lateinit var products: products
    lateinit var productList: ArrayList<products>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // getting the employeelist
        val employelist = Constants.getProductData()
        // Assign employeelist to ItemAdapter
        val itemAdapter = Adapter(employelist)
        // Set the LayoutManager that this RecyclerView will use.
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewhome)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.adapter = itemAdapter

        db = FirebaseFirestore.getInstance()

        db.collection("Products").get()
            .addOnSuccessListener {
                if (!it.isEmpty){
                    for (data in it.documents){
                        val product: products? = data.toObject(products::class.java)
                        if (product != null) {
                            productList.add(product)
                        }
                    }
                    recyclerView.adapter = Adapter(productList)
                }
            }
            .addOnFailureListener {

            }
    }
}






