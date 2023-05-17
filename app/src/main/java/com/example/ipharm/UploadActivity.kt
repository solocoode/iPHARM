package com.example.ipharm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.ipharm.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UploadActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUploadBinding
    private lateinit var database : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(LayoutInflater())
        setContentView(binding.root)

        binding.btnUpload.setOnClickListener {

            val productname = binding.edtProductname.text.toString()
            val productprice = binding.edtProductprice.text.toString()
            
            database = FirebaseDatabase.getInstance().getReference("products")
            val products = Products(productname, productprice)
            database.child(productname).setValue(products).addOnSuccessListener {

                binding.edtProductname.text.clear()
                binding.edtProductprice.text.clear()

                Toast.makeText(this, "Succesfully added", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {

                Toast.makeText(this, "Filaed to add", Toast.LENGTH_SHORT).show()

            }

        }
    }

    private fun LayoutInflater(): LayoutInflater {

        return LayoutInflater()

    }


}