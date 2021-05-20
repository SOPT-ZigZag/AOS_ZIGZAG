package org.sopt.ui.view.home.data

import org.sopt.ui.view.home.model.HomeTabViewPagerImage

interface HomeViewPagerDataSource {
    fun fetchData() : List<HomeTabViewPagerImage>
}