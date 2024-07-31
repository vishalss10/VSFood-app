package com.example.vsfood.Adapter

import android.media.RouteListingPreference.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vsfood.databinding.CartItemBinding

class cartAdapter(private val cartItem:MutableList<String>,private val cartItemprice:MutableList<String>,private val cartImage:MutableList<Int>) : RecyclerView.Adapter<cartAdapter.cartviewHolder>() {

private val itemquantity = IntArray(cartItem.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cartviewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return cartviewHolder(binding)
    }
    override fun onBindViewHolder(holder: cartviewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = cartItem.size

   inner class cartviewHolder( private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
           binding.apply {
               val quantity = itemquantity[position]
               cartfoodname.text = cartItem[position]
               cartitemprice.text = cartItemprice[position]
               cartimage.setImageResource(cartImage[position])
               cartquantity.text = quantity.toString()

            binding.minsbutton.setOnClickListener{
                deceaseQuantity(position)
            }

               binding.plusbutton.setOnClickListener{
                   increaseQuantity(position)
               }

               binding.deletebutton.setOnClickListener {
                   deleteItem(position)
               }

           }
        }
       private fun deceaseQuantity(position: Int){
           if(itemquantity[position]>1)
    {
               itemquantity[position]--
               binding.cartquantity.text=itemquantity[position].toString()
    }
}
       private fun increaseQuantity(position: Int){
           if(itemquantity[position]<10)
           {
               itemquantity[position]++
               binding.cartquantity.text=itemquantity[position].toString()
           }
       }

       private fun deleteItem(position: Int)
       {
           cartItem.removeAt(position)
           cartItemprice.removeAt(position)
           cartImage.removeAt(position)
           notifyItemRemoved(position)
           notifyItemRangeChanged(position,cartItem.size)
       }

    }


}