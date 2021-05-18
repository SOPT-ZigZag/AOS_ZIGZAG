package org.sopt.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.sopt.ui.view.home.tab.BestTab
import org.sopt.ui.view.home.tab.BrandTab
import org.sopt.ui.view.home.tab.HomeTab
import org.sopt.ui.view.home.tab.NewTab

class SampleAdapter {

    class PagerFragmentStateAdapter(fm: FragmentActivity): FragmentStateAdapter(fm){


        override fun getItemCount(): Int {
            return 4
        }
        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 ->(HomeTab())
                1 ->(BrandTab())
                2 ->(BestTab())
                else ->(NewTab())
            }
        }


    }

}