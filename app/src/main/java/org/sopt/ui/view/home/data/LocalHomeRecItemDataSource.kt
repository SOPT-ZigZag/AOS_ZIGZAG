package org.sopt.ui.view.home.data

import org.sopt.R
import org.sopt.ui.view.home.model.HomeRecItemInfo

class LocalHomeRecItemDataSource  : HomeRecItemDataSource {
    override fun fetchRecData(): MutableList<HomeRecItemInfo> {
        return mutableListOf(
                HomeRecItemInfo(
                        recItemImage = R.drawable.rc_image_1 ,
                        recItemPinkHeart = R.drawable.selector_pink_heart,
                        recItemIntense = "인텐스",
                        recItemName ="[모델 소장, 기획특가]베이브 탄탄 여리넥 하프" ,
                        recItemDis ="제트할인가",
                        recItemPrice = "129,000",
                        recItemPrice_2 = "35,900",
                        recItemPercent = "72%",
                        recItemFreeShipping = R.drawable.ic_free_shipping,
                        recItemGo = R.drawable.ic_today_go,
                        recItemBasket = R.drawable.selector_basket,
                        recTodayGo_2 = false

                ),
                HomeRecItemInfo(
                        recItemImage = R.drawable.rc_image_2 ,
                        recItemPinkHeart = R.drawable.selector_pink_heart,
                        recItemIntense = "인텐스",
                        recItemName ="[모델 소장, 기획특가]베이브 탄탄 여리넥 하프" ,
                        recItemDis ="제트할인가",
                        recItemPrice = "129,000",
                        recItemPrice_2 = "35,900",
                        recItemPercent = "72%",
                        recItemFreeShipping = R.drawable.ic_free_shipping,
                        recItemGo = R.drawable.ic_today_go,
                        recItemBasket = R.drawable.selector_basket,
                        recTodayGo_2 = true
                ),
                HomeRecItemInfo(
                        recItemImage = R.drawable.rc_image_3 ,
                        recItemPinkHeart = R.drawable.selector_pink_heart,
                        recItemIntense = "인텐스",
                        recItemName ="[모델 소장, 기획특가]베이브 탄탄 여리넥 하프" ,
                        recItemDis ="제트할인가",
                        recItemPrice = "129,000",
                        recItemPrice_2 = "35,900",
                        recItemPercent = "72%",
                        recItemFreeShipping = R.drawable.ic_free_shipping,
                        recItemGo = R.drawable.ic_today_go,
                        recItemBasket = R.drawable.selector_basket,
                        recTodayGo_2 = false
                )

        )
    }
}