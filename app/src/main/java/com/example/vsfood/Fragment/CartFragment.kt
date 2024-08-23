package com.example.vsfood.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vsfood.Adapter.cartAdapter
import com.example.vsfood.PayOutActivity
import com.example.vsfood.R
import com.example.vsfood.databinding.FragmentCartBinding
import com.example.vsfood.startActivity


class CartFragment : Fragment() {
    private lateinit var binding : FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartfoodname = listOf("Herbal Pancake","Fruit Salad","Green Noddle","Fruit Salad","Fruit Salad")
        val cartitemprice = listOf("$7","$9","$6","$2","$12","$5")
        val cartimage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu1)
        val adapter = cartAdapter(ArrayList(cartfoodname),ArrayList(cartitemprice),ArrayList(cartimage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter =adapter

        binding.proceedbutton.setOnClickListener {
            val intent = Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }

    companion object {


    }
}