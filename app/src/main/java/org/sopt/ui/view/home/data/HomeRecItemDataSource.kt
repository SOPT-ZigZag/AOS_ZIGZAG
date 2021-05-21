package org.sopt.ui.view.home.data

import org.sopt.ui.view.home.model.HomeRecItemInfo

interface HomeRecItemDataSource {
    fun fetchRecData() : MutableList<HomeRecItemInfo>
}