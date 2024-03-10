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
import com.jans.rv.shimmer.dark.mode.app.model.Categories

class CategoriesAdapter(private val categoriesList: List<Categories>?) :
        RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
            return ViewHolder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val post = categoriesList?.get(position)
            holder.titleTextView.text = post?.title
            holder.categoryTV.text = "Category: ${post?.category}"
            holder.priceTV.text =  "Price: ${post?.price.toString()} $"


            // Using Glide to load the image
            Glide.with(holder.itemView.context)
                .load(post?.image)
                .placeholder(R.drawable.ic_launcher_background) // Placeholder image while loading
                .error(R.drawable.ic_launcher_background) // Image to display if loading fails
                .into(holder.imageProduct)


        }

        override fun getItemCount(): Int = categoriesList!!.size

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
            var categoryTV: TextView = itemView.findViewById(R.id.category)
            var priceTV: TextView = itemView.findViewById(R.id.price)
            var imageProduct: ImageView = itemView.findViewById(R.id.img1)

        }
    }