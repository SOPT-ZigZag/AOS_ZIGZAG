package org.sopt.ui.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.databinding.FragmentHomeBinding
import org.sopt.ui.adapter.SampleAdapter

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

        val homeViewPagerAdapter = SampleAdapter.PagerFragmentStateAdapter(requireActivity())
        binding.vpHome.adapter = homeViewPagerAdapter
        binding.vpHome.isUserInputEnabled = false
        val homeTabLayout = binding.tlHome
        TabLayoutMediator(homeTabLayout, binding.vpHome ){tab, position ->
            tab.text = homeTabText[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}