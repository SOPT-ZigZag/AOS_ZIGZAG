package org.sopt.ui.view.home.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import org.sopt.R
import org.sopt.databinding.FragmentHomeTabBinding
import org.sopt.ui.adapter.SampleAdapter
import org.sopt.ui.view.home.data.HomeViewPagerDataSource
import org.sopt.ui.view.home.data.LocalHomeTabViewPagerDataSource
import org.sopt.ui.view.home.model.HomeTabViewPagerImage

class HomeTab : Fragment() {
    private val homeTabViewPagerAdapter by lazy{SampleAdapter.HomeTabViewPagerAdapter()}
    private lateinit var homeViewPagerDataSource : HomeViewPagerDataSource
    private var _binding: FragmentHomeTabBinding? = null
    private val binding get() = _binding!!

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
    }

    private fun initHomeImageViewPager() {
        val homeImageViewPager : ViewPager2 = binding.vpHomeImage
        homeImageViewPager.adapter = homeTabViewPagerAdapter
        homeTabViewPagerAdapter.submitList(fetchData())
    }

    private fun fetchData() : List<HomeTabViewPagerImage>{
        homeViewPagerDataSource = LocalHomeTabViewPagerDataSource()
        return homeViewPagerDataSource.fetchData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
