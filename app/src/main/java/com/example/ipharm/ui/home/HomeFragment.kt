package com.example.ipharm.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipharm.MyAdapter
import com.example.ipharm.ProductViewModel
import com.example.ipharm.Products
import com.example.ipharm.R
import com.example.ipharm.databinding.FragmentHomeBinding
import com.google.firebase.database.*


private lateinit var viewModel : ProductViewModel
private lateinit var userRecyclerView: RecyclerView
lateinit var adapter: MyAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userRecyclerView = view.findViewById(R.id.recyclerViewhome)
        userRecyclerView.layoutManager = GridLayoutManager(context, 2)
        userRecyclerView.setHasFixedSize(true)
        adapter = MyAdapter()
        userRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        viewModel.allProducts.observe(viewLifecycleOwner, Observer {

            adapter.updateproductList(it)

        })

    }

}




