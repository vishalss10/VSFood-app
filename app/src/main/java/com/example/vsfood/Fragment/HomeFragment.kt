package com.example.vsfood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.vsfood.Adapter.popularAdapter
import com.example.vsfood.MenuBottomSheetFragment
import com.example.vsfood.R
import com.example.vsfood.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.ViewMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(/* manager = */ parentFragmentManager,/* tag = */ "Test")
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagelist = ArrayList<SlideModel>()
        imagelist.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imagelist)
        imageSlider.setImageList(imagelist,ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun onItemSelected(position: Int) {
                val itemPosition = imagelist[position]
                val itemMessage ="Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })

        val foodName  = listOf("Burger","sandwich","momo","cake","cold drinks","watter")
        val price = listOf("$5","$8","$9","$10","$40","$1")
        val popularimage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu1,R.drawable.menu1)
        val adapter = popularAdapter(foodName,price,popularimage)
        binding.PopularRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.PopularRecycleView.adapter = adapter

    }

}
