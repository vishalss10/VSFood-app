package com.example.vsfood.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.vsfood.databinding.NotificationItemBinding
import java.util.ArrayList

class NotificationAdapter(private val notification_msg : ArrayList<String> , private val notification_Image : ArrayList<Int>) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
     val binding = NotificationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int = notification_msg.size

    inner class NotificationViewHolder(private val binding: NotificationItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                notificationTextView.text = notification_msg[position]
                notificationImageView.setImageResource(notification_Image[position])
            }
        }

    }
}