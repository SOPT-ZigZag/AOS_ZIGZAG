package org.sopt.ui.view.home.data

import org.sopt.ui.view.home.model.HomeThisItemTwoInfo

interface HomeThisItemTwoDataSource {
    fun fetchThisItemTwoData() : MutableList<HomeThisItemTwoInfo>
}