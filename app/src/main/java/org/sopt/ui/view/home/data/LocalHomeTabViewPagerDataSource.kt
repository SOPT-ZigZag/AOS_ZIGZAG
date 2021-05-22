package org.sopt.ui.view.home.data

import org.sopt.R
import org.sopt.ui.view.home.model.HomeTabViewPagerImage

class LocalHomeTabViewPagerDataSource : HomeViewPagerDataSource {
    override fun fetchData(): List<HomeTabViewPagerImage> {
        return listOf<HomeTabViewPagerImage>(
                HomeTabViewPagerImage(
                        homeViewPager = R.drawable.ic_image_1
                ),
                HomeTabViewPagerImage(
                        homeViewPager = R.drawable.ic_image_2
                ),
                HomeTabViewPagerImage(
                        homeViewPager = R.drawable.ic_image_3
                ),
                HomeTabViewPagerImage(
                        homeViewPager = R.drawable.ic_image_4
                )
        )
    }
}