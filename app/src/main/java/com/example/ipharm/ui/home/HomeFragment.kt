package com.example.ipharm.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipharm.MyAdapter
import com.example.ipharm.ProductViewModel
import com.example.ipharm.Products
import com.example.ipharm.R
import com.example.ipharm.databinding.FragmentHomeBinding
import java.util.*


lateinit var viewModel : ProductViewModel
lateinit var userRecyclerView : RecyclerView
lateinit var adapter: MyAdapter
private lateinit var searchView: SearchView




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
        searchView = requireView().findViewById(R.id.searchView)
    }

    lateinit var productList: ArrayList<Products>


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

        adapter.setOnItemClickListener(object : MyAdapter.onItemCickListener{

            override fun onItemClick(position: Int) {

                Toast.makeText(requireActivity(), "You clicked on $position", Toast.LENGTH_SHORT).show()

            }

        })

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        viewModel.allProducts.observe(viewLifecycleOwner, Observer {

            adapter.updateproductList(it)

        })

    }
}






