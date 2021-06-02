package org.sopt.remote.datasource

import org.sopt.remote.model.ResShoppingMall
import org.sopt.remote.model.ResStory

interface StoreRemoteDataSource {
    suspend fun getShoppingMall(): List<ResShoppingMall>
    suspend fun getStory(): List<ResStory>
}