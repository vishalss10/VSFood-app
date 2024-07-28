package com.example.vsfood.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vsfood.databinding.PolularItemBinding

class popularAdapter(private val Items:List<String>, private val Price:List<String>, private val Images:List<Int>) : RecyclerView.Adapter<popularAdapter.PopularViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PolularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
       val item = Items[position]
       val price = Price[position]
       val image = Images[position]

       holder.bind(item,price,image)
    }

    override fun getItemCount(): Int {
       return Items.size
    }


    class PopularViewHolder (private val binding : PolularItemBinding) : RecyclerView.ViewHolder(binding.root){
        private val imageview = binding.popularImage
        fun bind(item: String,price:String,image: Int) {
            binding.polularFoodName.text = item
            binding.popularPrice.text = price
            imageview.setImageResource(image)


        }

    }
}