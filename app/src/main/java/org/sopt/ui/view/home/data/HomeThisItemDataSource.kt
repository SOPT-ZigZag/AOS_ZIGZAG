package org.sopt.ui.view.home.data

import org.sopt.ui.view.home.model.HomeThisItemInfo

interface HomeThisItemDataSource {
    fun fetchThisItemData() : MutableList<HomeThisItemInfo>


}