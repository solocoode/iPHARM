package com.example.ipharm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ipharm.ProductsRepository

class ProductViewModel : ViewModel() {

    private var repository : ProductsRepository = ProductsRepository().getInstance()
    private val _allProducts = MutableLiveData<List<Products>>()
    val allProducts : LiveData<List<Products>> = _allProducts

    init {

        repository = ProductsRepository().getInstance()
        repository.loadUsers(_allProducts)

    }
}