package org.sopt.remote.model

data class ResShoppingMall(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val img: String,
        val store_idx: Int,
        val brand: String,
        val style: String,
        val coupon: Int,
        val bookmark: Boolean
    )
}