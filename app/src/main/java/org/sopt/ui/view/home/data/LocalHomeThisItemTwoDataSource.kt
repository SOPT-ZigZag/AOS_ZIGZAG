package org.sopt.ui.view.home.data

import org.sopt.R
import org.sopt.ui.view.home.model.HomeThisItemInfo
import org.sopt.ui.view.home.model.HomeThisItemTwoInfo

class LocalHomeThisItemTwoDataSource : HomeThisItemTwoDataSource {
    override fun fetchThisItemTwoData(): MutableList<HomeThisItemTwoInfo> {
        return mutableListOf(
                HomeThisItemTwoInfo(
                        R.drawable.this_item_two_1,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        true
                ),
                HomeThisItemTwoInfo(
                        R.drawable.this_item_two_2,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        false
                ),
                HomeThisItemTwoInfo(
                        R.drawable.this_item_two_3,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        false
                ),
                HomeThisItemTwoInfo(
                        R.drawable.this_item_two_4,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        true
                ),
                HomeThisItemTwoInfo(
                        R.drawable.this_item_two_5,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        true
                ),
                HomeThisItemTwoInfo(
                        R.drawable.this_item_two_6,
                        R.drawable.selector_heart_empty,
                        "인텐스",
                        "[셈디, 미희 착용]엘칸",
                        "제트할인가",
                        "129,000",
                        R.drawable.ic_free_shipping,
                        R.drawable.ic_today_go,
                        false
                )
        )
    }
}