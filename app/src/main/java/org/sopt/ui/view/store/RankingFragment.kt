package org.sopt.ui.view.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.R
import org.sopt.databinding.FragmentRankingBinding
import org.sopt.databinding.FragmentStoreBinding
import org.sopt.ui.adapter.BrandListAdapter
import org.sopt.ui.adapter.StoreViewPagerAdapter
import org.sopt.ui.view.store.data.datasource.BrandDataSource
import org.sopt.ui.view.store.data.datasource.BrandDataSourceImpl

class RankingFragment : Fragment() {
    private var _binding: FragmentRankingBinding? = null
    private val binding get() = _binding!!
    private val brandListAdapter = BrandListAdapter()
    private lateinit var brandDataSource: BrandDataSource

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRankingBinding.inflate(inflater, container, false)

        brandDataSource = BrandDataSourceImpl()
        binding.rvRanking.adapter = brandListAdapter
        brandListAdapter.data = brandDataSource.getBrandData()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}