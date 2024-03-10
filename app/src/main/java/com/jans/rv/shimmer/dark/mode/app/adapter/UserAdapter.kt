package com.jans.rv.shimmer.dark.mode.app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jans.rv.shimmer.dark.mode.app.R
import com.jans.rv.shimmer.dark.mode.app.model.Users

class UserAdapter(private val productsList: List<Users>?) :
        RecyclerView.Adapter<UserAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
            return ViewHolder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val post = productsList?.get(position)
            holder.titleTextView.text = post?.username
            holder.categoryTV.text = "Email Address: ${post?.email}"
            holder.priceTV.text =  "ID: ${post?.id.toString()}"


            // Using Glide to load the image
            Glide.with(holder.itemView.context)
                .load(R.drawable.img_1)
                .placeholder(R.drawable.ic_launcher_background) // Placeholder image while loading
                .error(R.drawable.ic_launcher_background) // Image to display if loading fails
                .into(holder.imageProduct)


        }

        override fun getItemCount(): Int = productsList!!.size

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
            var categoryTV: TextView = itemView.findViewById(R.id.category)
            var priceTV: TextView = itemView.findViewById(R.id.price)
            var imageProduct: ImageView = itemView.findViewById(R.id.img1)

        }
    }