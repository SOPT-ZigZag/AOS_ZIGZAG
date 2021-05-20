package org.sopt.ui.view.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.R
import org.sopt.databinding.FragmentStoreBinding
import org.sopt.ui.adapter.BrandListAdapter
import org.sopt.ui.adapter.StoreViewPagerAdapter
import org.sopt.ui.view.store.data.datasource.BrandDataSource


class StoreFragment : Fragment() {
    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!
    private lateinit var storeViewPagerAdapter: StoreViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val tabLabel = listOf(getString(R.string.ranking), getString(R.string.bookmark))

        binding.apply {
            storeViewPagerAdapter = StoreViewPagerAdapter(this@StoreFragment)
            with(storeViewPagerAdapter) {
                fragmentList = listOf(RankingFragment(), BookmarkFragment())

                vpStore.adapter = this
            }

            TabLayoutMediator(tlStore, vpStore) { tab, position ->
                tab.text = tabLabel[position]
            }.attach()

            rvStory
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}