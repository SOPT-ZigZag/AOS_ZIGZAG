package org.sopt.remote.model

data class ResStory(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val img: String,
        val story_idx: Int,
        val brand: String,
        val view: Int
    )
}