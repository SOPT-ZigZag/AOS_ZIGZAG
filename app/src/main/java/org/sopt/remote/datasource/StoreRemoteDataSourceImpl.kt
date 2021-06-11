package org.sopt.remote.datasource

import org.sopt.remote.ServiceCreator
import org.sopt.remote.model.ResShoppingMall
import org.sopt.remote.model.ResStory


class StoreRemoteDataSourceImpl: StoreRemoteDataSource {
    private val storeService = ServiceCreator.storeService

    override suspend fun getShoppingMall(): ResShoppingMall = storeService.getShoppingMall()
    override suspend fun getStory(): ResStory = storeService.getStory()
}