package com.example.vsfood

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.vsfood.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pay_out)
       binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ButtonBack.setOnClickListener {
            finish()
        }
      binding.placeMyOrder.setOnClickListener {
          val dialagbottom = CongratsSheetFragment()
          dialagbottom.show(supportFragmentManager,"Test")
      }
    }
}