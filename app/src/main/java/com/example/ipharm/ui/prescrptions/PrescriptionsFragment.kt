package com.example.ipharm.ui.prescrptions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ipharm.databinding.FragmentPrescriptionsBinding

class PrescriptionsFragment : Fragment() {

    private var _binding: FragmentPrescriptionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val prescriptionsViewModel =
            ViewModelProvider(this).get(PrescriptionsViewModel::class.java)

        _binding = FragmentPrescriptionsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
// upload prescription button should access camera to take a picture of prescription and store in firebase
// upload data to fire base and retrive them and display them in the recyleview