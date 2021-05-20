package org.sopt.ui.view.store.data.datasource

import org.sopt.ui.view.store.data.model.BrandData

interface BrandDataSource {
    fun getBrandData(): List<BrandData>
}