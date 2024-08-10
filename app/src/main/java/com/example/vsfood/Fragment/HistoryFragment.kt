package com.example.vsfood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vsfood.Adapter.BuyAgainAdapter
import com.example.vsfood.R
import com.example.vsfood.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter:BuyAgainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView(){
        val buyAgainFoodName = arrayListOf(
            "food 1",
            "food 2",
            "food 3",
        )
        val buyAgainFoodPrice = arrayListOf(
            "$ 25",
            "$ 25",
            "$ 25",
        )
        val buyAgainFoodImage = arrayListOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
        )
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.buyAgainRecyclerView.adapter = buyAgainAdapter
    }


    companion object {

    }
}