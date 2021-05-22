package org.sopt.ui.view.home.data

import org.sopt.R
import org.sopt.ui.view.home.model.HomeTodayGoInfo

class LocalHomeTodayGoDataSource : HomeTodayGoDataSource {
    override fun fetchTodayData(): MutableList<HomeTodayGoInfo> {
        return mutableListOf<HomeTodayGoInfo>(
                HomeTodayGoInfo(
                        homeTodayImage = R.drawable.today_delivery_img1,
                        homeTodayHeart = R.drawable.selector_heart_empty,
                        homeTodayIntense = "인텐스",
                        homeTodayName = "[셈디, 미희 착용]엘칸",
                        homeTodayDis = "제트할인가",
                        homeTodayPrice = "129,000",
                        homeTodayPrice_x = "35,900",
                        homeTodayPercent = "72%",
                        homeTodayFreeShipping = R.drawable.ic_free_shipping,
                        homeTodayGo = R.drawable.ic_today_go,
                        GoQuestion = true
                ),
                HomeTodayGoInfo(
                        homeTodayImage = R.drawable.today_delivery_img2,
                        homeTodayHeart = R.drawable.selector_heart_empty,
                        homeTodayIntense = "인텐스",
                        homeTodayName = "[셈디, 미희 착용]엘칸",
                        homeTodayDis = "제트할인가",
                        homeTodayPrice = "129,000",
                        homeTodayPrice_x = "35,900",
                        homeTodayPercent = "72%",
                        homeTodayFreeShipping = R.drawable.ic_free_shipping,
                        homeTodayGo = R.drawable.ic_today_go,
                        GoQuestion = false
                ),
                HomeTodayGoInfo(
                        homeTodayImage = R.drawable.today_delivery_img1,
                        homeTodayHeart = R.drawable.selector_heart_empty,
                        homeTodayIntense = "인텐스",
                        homeTodayName = "[셈디, 미희 착용]엘칸",
                        homeTodayDis = "제트할인가",
                        homeTodayPrice = "129,000",
                        homeTodayPrice_x = "35,900",
                        homeTodayPercent = "72%",
                        homeTodayFreeShipping = R.drawable.ic_free_shipping,
                        homeTodayGo = R.drawable.ic_today_go,
                        GoQuestion = true
                ),
                HomeTodayGoInfo(
                        homeTodayImage = R.drawable.today_delivery_img1,
                        homeTodayHeart = R.drawable.selector_heart_empty,
                        homeTodayIntense = "인텐스",
                        homeTodayName = "[셈디, 미희 착용]엘칸",
                        homeTodayDis = "제트할인가",
                        homeTodayPrice = "129,000",
                        homeTodayPrice_x = "35,900",
                        homeTodayPercent = "72%",
                        homeTodayFreeShipping = R.drawable.ic_free_shipping,
                        homeTodayGo = R.drawable.ic_today_go,
                        GoQuestion = false
                ),
                HomeTodayGoInfo(
                        homeTodayImage = R.drawable.today_delivery_img1,
                        homeTodayHeart = R.drawable.selector_heart_empty,
                        homeTodayIntense = "인텐스",
                        homeTodayName = "[셈디, 미희 착용]엘칸",
                        homeTodayDis = "제트할인가",
                        homeTodayPrice = "129,000",
                        homeTodayPrice_x = "35,900",
                        homeTodayPercent = "72%",
                        homeTodayFreeShipping = R.drawable.ic_free_shipping,
                        homeTodayGo = R.drawable.ic_today_go,
                        GoQuestion = true
                ),
                HomeTodayGoInfo(
                        homeTodayImage = R.drawable.today_delivery_img1,
                        homeTodayHeart = R.drawable.selector_heart_empty,
                        homeTodayIntense = "인텐스",
                        homeTodayName = "[셈디, 미희 착용]엘칸",
                        homeTodayDis = "제트할인가",
                        homeTodayPrice = "129,000",
                        homeTodayPrice_x = "35,900",
                        homeTodayPercent = "72%",
                        homeTodayFreeShipping = R.drawable.ic_free_shipping,
                        homeTodayGo = R.drawable.ic_today_go,
                        GoQuestion = true
                )
        )
    }
}