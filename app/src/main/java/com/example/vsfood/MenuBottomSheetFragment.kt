package com.example.vsfood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vsfood.Adapter.MenuAdapter
import com.example.vsfood.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)
        binding.ButtonBack.setOnClickListener {
            dismiss()
        }

        val menuFoodname = listOf("Herbal Pancake","Fruit Salad","Green Noddle","Fruit Salad","Fruit Salad",
            "Herbal Pancake","Fruit Salad","Green Noddle","Fruit Salad","Fruit Salad")
        val menuItemprice = listOf("$7","$9","$6","$2","$12","$5","$7","$9","$6","$2","$12","$5")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu1,
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu1)
        val adapter = MenuAdapter(ArrayList(menuFoodname),ArrayList(menuItemprice),ArrayList(menuImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter =adapter


        return binding.root
    }


    companion object {

    }
}