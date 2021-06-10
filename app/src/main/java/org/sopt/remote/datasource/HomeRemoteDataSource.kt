package org.sopt.remote.datasource

import org.sopt.remote.model.ResBanner
import org.sopt.remote.model.ResItem

interface HomeRemoteDataSource {
    suspend fun getBanner(): ResBanner
    suspend fun getItem(): ResItem
}