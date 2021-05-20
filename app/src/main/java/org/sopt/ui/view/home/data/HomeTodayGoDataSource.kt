package org.sopt.ui.view.home.data

import org.sopt.ui.view.home.model.HomeTodayGoInfo

interface HomeTodayGoDataSource {
    fun fetchTodayData() : MutableList<HomeTodayGoInfo>

}