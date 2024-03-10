package com.jans.rv.shimmer.dark.mode.app.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Categories(
        @SerializedName("id")
        @Expose
        var id: Int = 0,
        @SerializedName("title")
        @Expose
        var title: String = "",
        @SerializedName("price")
        @Expose
        var price: Double = 0.0,
        @SerializedName("description")
        @Expose
        var description: String = "",
        @SerializedName("category")
        @Expose
        var category: String = "",
        @SerializedName("image")
        @Expose
        var image: String = "",
//        @SerializedName("rating")
//        @Expose
//        var rating: List<Rating> = listOf()
    )
//data class Rating(
//    @SerializedName("rate")
//    @Expose
//    var rate: Double = 0.0,
//    @SerializedName("count")
//    @Expose
//    var count: Int = 0
//)