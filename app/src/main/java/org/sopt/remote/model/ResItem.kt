package org.sopt.remote.model

data class ResItem(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val item: List<Item>
    ) {
        data class Item(
            val _id: String,
            val img: String,
            val item_idx: Int,
            val brand_name: String,
            val item_name: String,
            val price: Int,
            val discount_idx: Int,
            val delivery_idx: Int,
            val delivery_today: Boolean
        )
    }
}