package com.example.ipharm

import androidx.lifecycle.MutableLiveData
import com.example.ipharm.Products
import com.google.firebase.database.*

class ProductsRepository {

    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("products")

    @Volatile private var INSTANCE : ProductsRepository ?= null

    fun getInstance() : ProductsRepository{
        return INSTANCE ?: synchronized(this){

            val instance = ProductsRepository()
            INSTANCE = instance
            instance
        }


    }


    fun loadUsers(productList : MutableLiveData<List<Products>>){

        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                try {

                    val _productList : List<Products> = snapshot.children.map { dataSnapshot ->

                        dataSnapshot.getValue(Products::class.java)!!

                    }

                    productList.postValue(_productList)

                }catch (e : Exception){


                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })


    }
}