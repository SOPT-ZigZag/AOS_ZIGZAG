package org.sopt.ui.view.store

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.R
import org.sopt.databinding.FragmentStoreBinding
import org.sopt.ui.adapter.StoreViewPagerAdapter
import org.sopt.ui.adapter.StoryListAdapter
import org.sopt.ui.view.store.data.datasource.StoreDataSource
import org.sopt.ui.view.store.data.datasource.StoreDataSourceImpl
import org.sopt.ui.view.story.StoryActivity


class StoreFragment : Fragment() {
    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!
    private lateinit var storeViewPagerAdapter: StoreViewPagerAdapter
    private val storyListAdapter = StoryListAdapter()
    private lateinit var storeDataSource: StoreDataSource

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
            storeDataSource = StoreDataSourceImpl()
            storeViewPagerAdapter = StoreViewPagerAdapter(this@StoreFragment)

            with(storeViewPagerAdapter) {
                fragmentList = listOf(RankingFragment(), BookmarkFragment())

                vpStore.adapter = this
            }

            TabLayoutMediator(tlStore, vpStore) { tab, position ->
                tab.text = tabLabel[position]
            }.attach()

            rvStory.adapter = storyListAdapter
            storyListAdapter.data = storeDataSource.getStoryData()

            storyListAdapter.setStoryButtonClickListener { img, brand ->
                startActivity(
                    Intent(requireActivity(), StoryActivity::class.java)
                    .putExtra(IMG, img)
                    .putExtra(BRAND_NAME, brand)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val IMG = "img"
        const val BRAND_NAME = "brand_name"
    }
}