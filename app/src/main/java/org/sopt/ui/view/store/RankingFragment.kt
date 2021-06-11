package org.sopt.ui.view.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.databinding.FragmentRankingBinding
import org.sopt.remote.datasource.StoreRemoteDataSourceImpl
import org.sopt.ui.adapter.BrandListAdapter
import org.sopt.ui.adapter.BrandListAdapter.Companion.Z_ONLY
import org.sopt.ui.adapter.BrandListAdapter.Companion.ALL_BRAND

class RankingFragment : Fragment() {
    private var _binding: FragmentRankingBinding? = null
    private val binding get() = _binding!!
    private val brandListAdapter = BrandListAdapter()
    private val storeRemoteDataSource = StoreRemoteDataSourceImpl()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRankingBinding.inflate(inflater, container, false)
        initAdapter()
        initClickEvent()

        return binding.root
    }

    private fun initAdapter() {
        binding.rvRanking.adapter = brandListAdapter
        getShoppingMall()
    }

    private fun initClickEvent() {
        binding.apply {
            chipCloth.setOnClickListener { it.isSelected = !it.isSelected }

            chipStyle.setOnClickListener { it.isSelected = !it.isSelected }

            chipAge.setOnClickListener { it.isSelected = !it.isSelected }

            ibCheck.setOnClickListener {
                it.isSelected = !it.isSelected

                when(it.isSelected) {
                    true -> brandListAdapter.setItemViewType(Z_ONLY)
                    false -> brandListAdapter.setItemViewType(ALL_BRAND)
                }
            }

            btnMore.setOnClickListener {
                //brandList.addAll(storeDataSource.getBrandData())
                //brandListAdapter.data = brandList
            }
        }
    }
    //lifecycleScope : 이 Fragment의 Lifecycle 안에 또 다른 쓰레드를 만들어줌.
    //globalScope : 애플리케이션 전체 (함부로 쓰면 안됨)
    private fun getShoppingMall() {
        lifecycleScope.launch {
            runCatching { storeRemoteDataSource.getShoppingMall() }
                .onSuccess { brandListAdapter.data = it.data.store }
                .onFailure { it.printStackTrace() }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}