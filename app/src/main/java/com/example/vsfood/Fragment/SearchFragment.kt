package com.example.vsfood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vsfood.Adapter.MenuAdapter
import com.example.vsfood.R
import com.example.vsfood.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

  private lateinit var binding : FragmentSearchBinding
  private lateinit var adapter: MenuAdapter
  private val orignalMenufood = listOf("Herbal Pancake","Fruit Salad","Green Noddle","Fruit Salad","Fruit Salad",
        "Herbal Pancake","Fruit Salad","Green Noddle","Fruit Salad","Fruit Salad")
    private val orignalPrice =
       listOf("$7","$9","$6","$2","$12","$5","$7","$9","$6","$2","$12","$5")
    private val orignalImage = listOf(
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filterMenufoodName = mutableListOf<String>()
    private val filterMenuPrice = mutableListOf<String>()
    private val filterMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filterMenufoodName,filterMenuPrice,filterMenuImage
        )
        binding.searchRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecyclerview.adapter = adapter

        setupSearchView()
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filterMenufoodName.clear()
        filterMenuPrice.clear()
        filterMenuImage.clear()

        filterMenufoodName.addAll(orignalMenufood)
        filterMenuPrice.addAll(orignalPrice)
        filterMenuImage.addAll(orignalImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(query: String): Boolean {
            filterMenuItems(query)
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            filterMenuItems(newText)
            return true
        }
    })
    }


    private fun filterMenuItems(query: String?) {
        filterMenufoodName.clear()
        filterMenuPrice.clear()
        filterMenuImage.clear()

        orignalMenufood.forEachIndexed { index, foodname ->
            if (foodname.contains(query ?: "", ignoreCase = true)) {
                filterMenufoodName.add(foodname)
                filterMenuPrice.add(orignalPrice[index])
                filterMenuImage.add(orignalImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}



