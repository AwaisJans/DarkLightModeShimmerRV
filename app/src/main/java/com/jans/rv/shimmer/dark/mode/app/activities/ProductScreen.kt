package com.jans.rv.shimmer.dark.mode.app.activities

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jans.rv.shimmer.dark.mode.app.appUtils.ConfigApp.Companion.defaultModule1TintColor
import com.jans.rv.shimmer.dark.mode.app.appUtils.DarkModePreference
import com.jans.rv.shimmer.dark.mode.app.R
import com.jans.rv.shimmer.dark.mode.app.adapter.ProductsAdapter
import com.jans.rv.shimmer.dark.mode.app.apiUtil.ApiService
import com.jans.rv.shimmer.dark.mode.app.appUtils.ConfigApp.Companion.assignColorWithDarkLightMode
import com.jans.rv.shimmer.dark.mode.app.model.Module
import com.jans.rv.shimmer.dark.mode.app.shimmerEffect.ShimmerFrameLayout


class ProductScreen : AppCompatActivity() {

    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var imgSample: ImageView
    private lateinit var tvNoConnection: TextView
    private lateinit var shimmerLayout: ShimmerFrameLayout


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_screen)

        title = "Product Screen"
        recyclerView = findViewById(R.id.recyclerView)
        tvNoConnection = findViewById(R.id.tvNoConnection)
        shimmerLayout = findViewById(R.id.shimmerLayout)
        imgSample = findViewById(R.id.testImg)
        fetchData()

        // here is the dark mode coding
        assignColorWithDarkLightMode(imgSample,"Module1")


    }

    private fun fetchData() {

        ApiService.getProducts({ posts ->
            if (posts != null) {
                Handler().postDelayed({
                    productsAdapter = ProductsAdapter(posts)
                    recyclerView.layoutManager = LinearLayoutManager(this)
                    recyclerView.adapter = productsAdapter
                    shimmerLayout.visibility = View.GONE
                }, 1000)

            } else {
                Handler().postDelayed({
                    shimmerLayout.visibility = View.GONE
                    tvNoConnection.visibility = View.VISIBLE
                }, 1000)

            }
        }, this)
    }

}


