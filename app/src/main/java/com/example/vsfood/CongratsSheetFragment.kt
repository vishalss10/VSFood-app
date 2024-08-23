package com.example.vsfood

import android.app.Activity
import android.app.DialogFragment
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vsfood.databinding.FragmentCongratsSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CongratsSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentCongratsSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCongratsSheetBinding.inflate(layoutInflater,container,false)

        binding.goHomebutton.setOnClickListener {
            val intent = Intent(requireContext(),MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {

    }
}