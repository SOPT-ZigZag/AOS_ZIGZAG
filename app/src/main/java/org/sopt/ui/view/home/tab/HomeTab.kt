package org.sopt.ui.view.home.tab

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.launch
import org.sopt.databinding.FragmentHomeTabBinding
import org.sopt.remote.ServiceCreator
import org.sopt.remote.datasource.HomeRemoteDataSource
import org.sopt.remote.datasource.HomeRemoteDataSourceImpl
import org.sopt.remote.model.ResBanner
import org.sopt.ui.adapter.*
import org.sopt.ui.adapter.HomeTodayGoAdapter.Companion.ALL_BRAND
import org.sopt.ui.adapter.HomeTodayGoAdapter.Companion.TODAY_GO
import org.sopt.ui.view.home.data.*
import org.sopt.ui.view.home.model.*

class HomeTab : Fragment() {
    private val recDataList = mutableListOf<HomeRecItemInfo>()
    private val homeImageViewPagerAdapter = HomeTabViewPagerAdapter()
    private val homeTodayGoAdapter = HomeTodayGoAdapter()
    private val homeRecItemAdapter = HomeRecItemAdapter()
    private val homeThisItemAdapter = HomeThisItemAdapter()
    private val homeThisItemTwoAdapter = HomeThisItemTwoAdapter()
    private val homeThisItemDataSource = LocalHomeThisItemDataSource()
    private val homeRecItemDataSource = LocalHomeRecItemDataSource()
    private val homeTodayGoDataSource = LocalHomeTodayGoDataSource()
    private val homeThisItemTwoDataSource = LocalHomeThisItemTwoDataSource()
    private val homeTabViewPagerDataSource = LocalHomeTabViewPagerDataSource()
    private var _binding: FragmentHomeTabBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화 되지 않았습니다.")
    private var currentPosition = 0
    private var homeViewPagerHandler = HomeViewPagerHandler()
    private val homeRemoteDataSource = HomeRemoteDataSourceImpl()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHomeImageViewPager()
        initHomeTodayGo()
        initHomeRecItem()
        initClickEvent()
        initHomeThisItem()
        initHomeThisItemTwo()
    }

    private fun initHomeImageViewPager() {
        binding.apply {
            with(vpHomeImage) {
                adapter = homeImageViewPagerAdapter

                getBanner()
                sdiHomeTabImage.setViewPager2(this)
                setCurrentItem(currentPosition, false)

                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageScrollStateChanged(state: Int) {
                        super.onPageScrollStateChanged(state)
                        when (state) {
                            ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart()
                            ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                        }
                    }
                })
            }
        }
    }
    private fun getBanner(){
        lifecycleScope.launch {
            runCatching {homeRemoteDataSource.getBanner()}
                .onSuccess { homeImageViewPagerAdapter.data = listOf(it) }
                .onFailure { it.printStackTrace() }
        }
    }


    private fun getItem(){
        lifecycleScope.launch {
            runCatching {homeRemoteDataSource.getItem() }
                .onSuccess { homeRecItemAdapter.data = it.data.item.subList(0,3)}
                .onFailure{it.printStackTrace()}

        }
    }
    private fun initHomeTodayGo() {
        binding.rvTodayDelivery.adapter = homeTodayGoAdapter
        homeTodayGoAdapter.data = fetchTodayData().subList(0, 3)
    }

    private fun initHomeRecItem() {
        binding.rvRecItem.adapter = homeRecItemAdapter
        recDataList.addAll(fetchRecData())
        getItem()
    }

    private fun initHomeThisItem() {
        binding.rvThisItem.adapter = homeThisItemAdapter
        homeThisItemAdapter.data =fetchThisItemData()
    }

    private fun initHomeThisItemTwo() {
        binding.rvThisItemTwo.adapter = homeThisItemTwoAdapter
        homeThisItemTwoAdapter.submitList(fetchThisItemTwoData())
    }

    private fun initClickEvent() {
        binding.apply {
            ivSelectorCheck.setOnClickListener {
                it.isSelected = !it.isSelected

                when (it.isSelected) {
                    true -> homeTodayGoAdapter.setItemViewType(TODAY_GO)
                    false -> homeTodayGoAdapter.setItemViewType(ALL_BRAND)
                }
            }

            tvAgree.setOnClickListener {
                recDataList.addAll(fetchRecData())
                getItem()
            }

            ivReset.setOnClickListener {
                val todayDataList = fetchTodayData()
                todayDataList.shuffle()
                homeTodayGoAdapter.data = todayDataList.subList(0,3)
            }

            ivReset2.setOnClickListener {
                val recDataList = fetchRecData()
                recDataList.shuffle()
                getItem()
            }

            ivReset3.setOnClickListener {
                val thisItemList = fetchThisItemData()
                thisItemList.shuffle()
                homeThisItemAdapter.data = thisItemList
            }
        }
    }

    private fun fetchTodayData(): MutableList<HomeTodayGoInfo> = homeTodayGoDataSource.fetchTodayData()

    private fun fetchRecData(): MutableList<HomeRecItemInfo> = homeRecItemDataSource.fetchRecData().subList(0, 3)

    private fun fetchThisItemData(): MutableList<HomeThisItemInfo> = homeThisItemDataSource.fetchThisItemData()

    private fun fetchThisItemTwoData(): MutableList<HomeThisItemTwoInfo> = homeThisItemTwoDataSource.fetchThisItemTwoData()


    private fun autoScrollStart() {
        homeViewPagerHandler.removeMessages(0)
        homeViewPagerHandler.sendEmptyMessageDelayed(0, INTERVAL_TIME)
    }

    private fun autoScrollStop() {
        homeViewPagerHandler.removeMessages(0)
    }

    private inner class HomeViewPagerHandler : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if (msg.what == 0) {
                binding.vpHomeImage.setCurrentItem(++currentPosition, true)
                autoScrollStart()
            }

            if (currentPosition == 4)
                currentPosition = -1
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        autoScrollStart()
    }

    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }

    companion object {
        private const val INTERVAL_TIME = 2000.toLong()
    }
}
