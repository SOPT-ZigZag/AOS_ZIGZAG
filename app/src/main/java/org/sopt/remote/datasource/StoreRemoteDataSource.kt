package org.sopt.remote.datasource

import org.sopt.remote.model.ResShoppingMall
import org.sopt.remote.model.ResStory

interface StoreRemoteDataSource {
    suspend fun getShoppingMall(): ResShoppingMall
    suspend fun getStory(): ResStory
}