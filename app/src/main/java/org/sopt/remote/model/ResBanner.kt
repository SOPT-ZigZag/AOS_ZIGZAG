package org.sopt.remote.model

data class ResBanner(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val banner: List<Banner>
    ) {
        data class Banner(
            val _id: String,
            val img: String,
            val banner_idx: Int
        )
    }
}