package org.sopt.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.sopt.ui.view.store.StoreFragment

class StoreViewPagerAdapter(fragment: StoreFragment) : FragmentStateAdapter(fragment.requireActivity()) {
    var fragmentList = listOf<Fragment>()

    override fun getItemCount(): Int {
        return fragmentList.count()
    }

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}