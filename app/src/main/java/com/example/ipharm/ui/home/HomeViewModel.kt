package com.example.ipharm.ui.home


import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.ipharm.Products
import com.google.firebase.database.DatabaseReference

class HomeViewModel : ViewModel() {
    private lateinit var dbref : DatabaseReference
    private lateinit var productRecyclerView: RecyclerView
    private lateinit var productArrayList : ArrayList<Products>





}