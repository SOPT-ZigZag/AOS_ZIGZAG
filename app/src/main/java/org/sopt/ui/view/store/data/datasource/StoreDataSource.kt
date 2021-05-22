package org.sopt.ui.view.store.data.datasource

import org.sopt.ui.view.store.data.model.BrandData
import org.sopt.ui.view.store.data.model.StoryData

interface StoreDataSource {
    fun getBrandData(): List<BrandData>
    fun getStoryData(): List<StoryData>
}