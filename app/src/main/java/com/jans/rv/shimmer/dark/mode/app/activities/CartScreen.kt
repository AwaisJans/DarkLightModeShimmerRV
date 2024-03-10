package com.jans.rv.shimmer.dark.mode.app.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jans.rv.shimmer.dark.mode.app.appUtils.ConfigApp.Companion.defaultModule3TintColor
import com.jans.rv.shimmer.dark.mode.app.appUtils.DarkModePreference
import com.jans.rv.shimmer.dark.mode.app.R
import com.jans.rv.shimmer.dark.mode.app.adapter.CartsAdapter
import com.jans.rv.shimmer.dark.mode.app.apiUtil.ApiService
import com.jans.rv.shimmer.dark.mode.app.appUtils.ConfigApp
import com.jans.rv.shimmer.dark.mode.app.model.Module
import com.jans.rv.shimmer.dark.mode.app.shimmerEffect.ShimmerFrameLayout


class CartScreen : AppCompatActivity() {

    private lateinit var cartsAdapter: CartsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvNoConnection:TextView
    private lateinit var shimmerLayout: ShimmerFrameLayout
    private lateinit var imgSample: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_screen)


        title = "Cart Screen"


        recyclerView = findViewById(R.id.recyclerView)
        tvNoConnection = findViewById(R.id.tvNoConnection)
        shimmerLayout = findViewById(R.id.shimmerLayout)
        imgSample = findViewById(R.id.testImg)

        fetchData()

        // here is the dark mode coding
        ConfigApp.assignColorWithDarkLightMode(imgSample, "Module3")


    }

    private fun fetchData() {

        ApiService.getCarts ({ posts ->
            if (posts != null) {
                Handler().postDelayed({
                    cartsAdapter = CartsAdapter(posts)
                    recyclerView.layoutManager = LinearLayoutManager(this)
                    recyclerView.adapter = cartsAdapter
                    shimmerLayout.visibility = View.GONE
                },1000)

            } else {
                Handler().postDelayed({
                    shimmerLayout.visibility = View.GONE
                    tvNoConnection.visibility = View.VISIBLE
                },1000)

            }
        },this)
    }

}