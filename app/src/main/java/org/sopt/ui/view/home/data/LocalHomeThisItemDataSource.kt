package org.sopt.ui.view.home.data

import org.sopt.R
import org.sopt.ui.view.home.model.HomeThisItemInfo
import org.sopt.ui.view.home.model.HomeTodayGoInfo

class LocalHomeThisItemDataSource : HomeThisItemDataSource {
    override fun fetchThisItemData(): MutableList<HomeThisItemInfo> {
        return mutableListOf<HomeThisItemInfo>(
                HomeThisItemInfo(
                        R.drawable.today_delivery_img1,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        "35,900",
                        "72%",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        true
                ),
                HomeThisItemInfo(
                        R.drawable.today_delivery_img2,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        "35,900",
                        "72%",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        true
                ),
                HomeThisItemInfo(
                        R.drawable.today_delivery_img1,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        "35,900",
                        "72%",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        true
                ),
                HomeThisItemInfo(
                        R.drawable.today_delivery_img2,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        "35,900",
                        "72%",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        false
                ),
                HomeThisItemInfo(
                        R.drawable.today_delivery_img1,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        "35,900",
                        "72%",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        false
                ),
        )

    }
}