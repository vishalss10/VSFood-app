package com.example.vsfood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vsfood.Adapter.NotificationAdapter
import com.example.vsfood.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList


class NotificationBottom : BottomSheetDialogFragment(){
    private lateinit var binding: FragmentNotificationBottomBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater,container,false)

        val notifications = listOf(
            "Your order has been Canceled Successfully",
            "Order has been taken by the driver",
            "Congrats Your Order Placed"
        )

        val notification_img = listOf(
            R.drawable.sademoji,
            R.drawable.truck,
            R.drawable.illustration,

        )

        val adapter = NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notification_img)
        )

        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter

        binding.notificationBackButton.setOnClickListener {
            dismiss()
        }
        return binding.root
    }


    companion object {


    }
}