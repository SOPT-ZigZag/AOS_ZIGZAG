package org.sopt.remote.datasource

import org.sopt.remote.ServiceCreator
import org.sopt.remote.model.ResBanner
import org.sopt.remote.model.ResItem
import org.sopt.remote.model.ResShoppingMall
import org.sopt.remote.model.ResStory

class HomeRemoteDataSourceImpl : HomeRemoteDataSource {
    private val homeService = ServiceCreator.homeService
    override suspend fun getBanner(): ResBanner = homeService.getBanner()

    override suspend fun getItem(): ResItem = homeService.getItem()
}