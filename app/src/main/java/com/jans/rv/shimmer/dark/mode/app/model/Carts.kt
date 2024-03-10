package com.jans.rv.shimmer.dark.mode.app.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Carts(
    @SerializedName("id")
        @Expose
        var id: Int = 0,
    @SerializedName("userId")
        @Expose
        var userId: Int = 0,
    @SerializedName("date")
        @Expose
        var date: String = "",
    @SerializedName("products")
        @Expose
        var products: List<Product> = listOf(),
    @SerializedName("__v")
        @Expose
        var v: Int = 0
    )


data class Product(
    @SerializedName("productId")
    @Expose
    var productId: Int = 0,
    @SerializedName("quantity")
    @Expose
    var quantity: Int = 0
)