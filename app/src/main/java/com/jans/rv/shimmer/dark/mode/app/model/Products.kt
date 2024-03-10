package com.jans.rv.shimmer.dark.mode.app.model

import android.os.Parcel
import android.os.Parcelable

data class Products(
    val id: Int,
    val title: String,
    val category: String,
    val image: String,
    val price: Double
)

