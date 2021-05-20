package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import org.sopt.databinding.ItemHomeTabImageBinding
import org.sopt.ui.view.home.model.HomeTabViewPagerImage
import org.sopt.ui.view.home.tab.BestTab
import org.sopt.ui.view.home.tab.BrandTab
import org.sopt.ui.view.home.tab.HomeTab
import org.sopt.ui.view.home.tab.NewTab

class SampleAdapter {

    class PagerFragmentStateAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {


        override fun getItemCount(): Int {
            return 4
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> (HomeTab())
                1 -> (BrandTab())
                2 -> (BestTab())
                else -> (NewTab())
            }
        }
    }


    class HomeTabViewPagerAdapter : ListAdapter<HomeTabViewPagerImage, HomeTabViewPagerAdapter.HomeTabViewPagerViewHolder>(HomeTabViewPagerViewHolder.HomeTabViewPagerDiffUtil) {

        class HomeTabViewPagerViewHolder(private val binding: ItemHomeTabImageBinding) :
                RecyclerView.ViewHolder(binding.root) {
            fun onBind(homeViewPagerData: HomeTabViewPagerImage) {
                Glide.with(itemView).load(homeViewPagerData).into(binding.ivHomeTabImage)
            }

            object HomeTabViewPagerDiffUtil : DiffUtil.ItemCallback<HomeTabViewPagerImage>() {
                override fun areItemsTheSame(oldItem: HomeTabViewPagerImage, newItem: HomeTabViewPagerImage): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }

                override fun areContentsTheSame(oldItem: HomeTabViewPagerImage, newItem: HomeTabViewPagerImage): Boolean {
                    return oldItem == newItem
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTabViewPagerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemHomeTabImageBinding.inflate(layoutInflater, parent, false)
            return HomeTabViewPagerViewHolder(binding)
        }

        override fun onBindViewHolder(holder: HomeTabViewPagerViewHolder, position: Int) {
            holder.onBind(getItem(position))
        }

    }
}

