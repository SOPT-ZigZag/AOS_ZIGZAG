package org.sopt.ui.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.databinding.FragmentHomeBinding
import org.sopt.ui.adapter.ZigZagViewPagerAdapter
import org.sopt.ui.view.home.tab.BestTab
import org.sopt.ui.view.home.tab.BrandTab
import org.sopt.ui.view.home.tab.HomeTab
import org.sopt.ui.view.home.tab.NewTab

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeTabText = arrayListOf("홈", "Brand", "베스트", "신상")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHomeViewPager()
    }

    private fun initHomeViewPager(){
        binding.apply {
            val homeViewPagerAdapter = ZigZagViewPagerAdapter(requireActivity())
            with(homeViewPagerAdapter) {
                fragmentList = listOf(HomeTab(), BrandTab(), BestTab(), NewTab())
                with(vpHome) {
                    adapter = homeViewPagerAdapter
                    isUserInputEnabled = false
                }
            }

            TabLayoutMediator(tlHome, vpHome) { tab, position ->
                tab.text = homeTabText[position]
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}