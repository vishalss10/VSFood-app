package com.example.vsfood.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vsfood.databinding.BuyAgainItemBinding
import java.util.ArrayList

class BuyAgainAdapter(private val BuyAgainFoodName:ArrayList<String>, private val BuyAgainFoodPrice: ArrayList<String>,
                      private val BuyAgainFoodImage: ArrayList<Int>) : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
       val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
      holder.bind(BuyAgainFoodName[position],BuyAgainFoodPrice[position],BuyAgainFoodImage[position])
    }

    override fun getItemCount(): Int = BuyAgainFoodName.size

    class BuyAgainViewHolder(private val binding: BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(foodName: String, foodPrice: String, foodImage: Int) {
            binding.buyAgainFoodName.text=foodName
            binding.buyAgainPrice.text=foodPrice
            binding.buyAgianImage.setImageResource(foodImage)
        }

    }



}