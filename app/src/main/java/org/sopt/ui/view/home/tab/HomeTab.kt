package org.sopt.ui.view.home.tab

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import org.sopt.R
import org.sopt.databinding.FragmentHomeTabBinding
import org.sopt.ui.adapter.SampleAdapter
import org.sopt.ui.adapter.SampleAdapter.HomeTodayGoAdapter.Companion.ALL_BRAND
import org.sopt.ui.adapter.SampleAdapter.HomeTodayGoAdapter.Companion.TODAY_GO
import org.sopt.ui.view.home.data.*
import org.sopt.ui.view.home.model.*

class HomeTab : Fragment() {
    private val homeImageViewPagerAdapter = SampleAdapter.HomeTabViewPagerAdapter()
    private val homeTodayGoAdapter = SampleAdapter.HomeTodayGoAdapter()
    private val homeRecItemAdapter = SampleAdapter.HomeRecItemAdapter()
    private val homeThisItemAdapter = SampleAdapter.HomeThisItemAdapter()
    private val homeThisItemTwoAdapter = SampleAdapter.HomeThisItemTwoAdapter()
    private lateinit var homeThisItemDataSource: HomeThisItemDataSource
    private lateinit var homeRecItemDataSource : HomeRecItemDataSource
    private lateinit var homeTodayGoDataSource : HomeTodayGoDataSource
    private lateinit var homeThisItemTwoDataSource: HomeThisItemTwoDataSource
    private var _binding: FragmentHomeTabBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화 되지 않았습니다.")
    private var numViewPager = 4
    private var currentPosition = 0
    private var homeViewPagerHandler = HomeViewPagerHandler()
    private val intervalTime = 2000.toLong()

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
        initClickButton()
        initHomeThisItem()
        initHomeThisItemTwo()

    }


    private fun initHomeImageViewPager() {
        binding.vpHomeImage.adapter = homeImageViewPagerAdapter
        homeImageViewPagerAdapter.data = getImageList()
        binding.sdiHomeTabImage.setViewPager2(binding.vpHomeImage)
        binding.vpHomeImage.setCurrentItem(currentPosition, false)

        binding.vpHomeImage.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state) {
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }
    }
    private fun initHomeTodayGo(){
        binding.rvTodayDelivery.adapter = homeTodayGoAdapter
        homeTodayGoAdapter.data = fetchTodayData()
    }
    private fun initHomeRecItem(){
        binding.rvRecItem.adapter = homeRecItemAdapter
        homeRecItemAdapter.submitList(fetchRecData())
    }

    private fun initHomeThisItem(){
        binding.rvThisItem.adapter = homeThisItemAdapter
        homeThisItemAdapter.submitList(fetchThisItemData())
    }
    private fun initHomeThisItemTwo(){
        binding.rvThisItemTwo.adapter = homeThisItemTwoAdapter
        binding.rvThisItemTwo.layoutManager = GridLayoutManager(this.context,2)
        homeThisItemTwoAdapter.submitList(fetchThisItemTwoData())
    }

    private fun initClickButton(){
        binding.ivSelectorCheck.setOnClickListener{
            it.isSelected = !it.isSelected

            when(it.isSelected){
                true -> SampleAdapter.HomeTodayGoAdapter().setItemViewType(TODAY_GO)
                false -> SampleAdapter.HomeTodayGoAdapter().setItemViewType(ALL_BRAND)
            }
        }
    }



    private fun fetchTodayData(): MutableList<HomeTodayGoInfo>{
        homeTodayGoDataSource = LocalHomeTodayGoDataSource()
        return homeTodayGoDataSource.fetchTodayData()
    }

    private fun fetchRecData() : MutableList<HomeRecItemInfo>{
        homeRecItemDataSource = LocalHomeRecItemDataSource()
        return homeRecItemDataSource.fetchRecData().subList(0,3)
    }

    private fun fetchThisItemData() : MutableList<HomeThisItemInfo>{
        homeThisItemDataSource = LocalHomeThisItemDataSource()
        return homeThisItemDataSource.fetchThisItemData().subList(0,3)
    }

    private fun fetchThisItemTwoData() : MutableList<HomeThisItemTwoInfo>{
        homeThisItemTwoDataSource = LocalHomeThisItemTwoDataSource()
        return homeThisItemTwoDataSource.fetchThisItemTwoData()
    }



    private fun getImageList(): MutableList<HomeTabViewPagerImage> {
        return mutableListOf<HomeTabViewPagerImage>(HomeTabViewPagerImage(R.drawable.ic_image_1),
                HomeTabViewPagerImage(R.drawable.ic_image_2), HomeTabViewPagerImage(R.drawable.ic_image_3),
                HomeTabViewPagerImage(R.drawable.ic_image_4))
    }

    private fun autoScrollStart(intervalTime: Long) {
        homeViewPagerHandler.removeMessages(0)
        homeViewPagerHandler.sendEmptyMessageDelayed(0, intervalTime)
    }

    private fun autoScrollStop() {
        homeViewPagerHandler.removeMessages(0)
    }

    private inner class HomeViewPagerHandler : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if (msg.what == 0) {
                binding.vpHomeImage.setCurrentItem(++currentPosition, true)
                autoScrollStart(intervalTime)
            }
            if (currentPosition == 4){
                currentPosition = -1
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }
}
