package org.sopt.remote.model

import com.google.gson.annotations.SerializedName

data class ResShoppingMall(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val store: List<Store>
    ) {
        data class Store(
            val _id: String,
            val img: String,
            val store_idx: Int,
            val brand: String,
            val style: String,
            val coupon: Int,
            val bookmark: String,
            @SerializedName("z_only")
            val zOnly: Boolean,
            val follower: Int
        )
    }
}