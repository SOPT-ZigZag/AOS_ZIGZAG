package org.sopt.ui.view.store.data.datasource

import org.sopt.R
import org.sopt.ui.view.store.data.model.BrandData
import org.sopt.ui.view.store.data.model.StoryData

class StoreDataSourceImpl: StoreDataSource {
    override fun getBrandData(): List<BrandData> {
        return listOf<BrandData>(
            BrandData(
                name = "육육걸즈",
                zOnly = true,
                type = "심플베이직.러블리",
                coupon = "최대 1,000원 쿠폰",
                follower = "194.5만",
                rankChange = 0,
                img = R.drawable.img_moderntage_1
            ),
            BrandData(
                name = "슬로우엔드",
                zOnly = false,
                type = "심플베이직.러블리",
                coupon = "최대 1,000원 쿠폰",
                follower = "194.5만",
                rankChange = 1,
                img = R.drawable.img_moderntage_2
            ),
            BrandData(
                name = "핫핑",
                zOnly = true,
                type = "심플베이직.러블리",
                coupon = "최대 1,000원 쿠폰",
                follower = "194.5만",
                rankChange = -1,
                img = R.drawable.img_moderntage_3
            ),
            BrandData(
                name = "고고씽",
                zOnly = false,
                type = "심플베이직.러블리",
                coupon = "최대 1,000원 쿠폰",
                follower = "194.5만",
                rankChange = 0,
                img = R.drawable.img_moderntage_1
            ),
            BrandData(
                name = "육육걸즈",
                zOnly = true,
                type = "심플베이직.러블리",
                coupon = "최대 1,000원 쿠폰",
                follower = "194.5만",
                rankChange = 0,
                img = R.drawable.img_moderntage_2
            )
        )
    }

    override fun getStoryData(): List<StoryData> {
        return listOf<StoryData>(
            StoryData(
                img = R.drawable.img_moderntage_1,
                brand = "모던티지",
                view = "11.5만"
            ),
            StoryData(
                img = R.drawable.img_moderntage_2,
                brand = "모던티지",
                view = "11.5만"
            ),
            StoryData(
                img = R.drawable.img_moderntage_3,
                brand = "모던티지",
                view = "11.5만"
            ),
            StoryData(
                img = R.drawable.img_moderntage_1,
                brand = "모던티지",
                view = "11.5만"
            ),
            StoryData(
                img = R.drawable.img_moderntage_2,
                brand = "모던티지",
                view = "11.5만"
            )
        )
    }
}