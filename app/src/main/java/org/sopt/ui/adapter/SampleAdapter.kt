package org.sopt.ui.adapter

import android.media.browse.MediaBrowser
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import org.sopt.databinding.ItemHomeTabImageBinding
import org.sopt.databinding.ItemHomeTodayDeliveryBinding
import org.sopt.ui.view.home.model.HomeTabViewPagerImage
import org.sopt.ui.view.home.model.HomeTodayGoInfo
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


    class HomeTabViewPagerAdapter : RecyclerView.Adapter<HomeTabViewPagerAdapter.HomeTabViewPagerViewHolder>() {
        private val _data = mutableListOf<HomeTabViewPagerImage>()
        var data: List<HomeTabViewPagerImage> = _data
            set(value) {
                _data.clear()
                _data.addAll(value)
                notifyDataSetChanged()
            }

        class HomeTabViewPagerViewHolder(private val binding: ItemHomeTabImageBinding) :
                RecyclerView.ViewHolder(binding.root) {
            fun onBind(homeViewPagerData: HomeTabViewPagerImage) {
                binding.ivHomeTabImage.setImageResource(homeViewPagerData.homeViewPager)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTabViewPagerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemHomeTabImageBinding.inflate(layoutInflater, parent, false)
            return HomeTabViewPagerViewHolder(binding)
        }

        override fun onBindViewHolder(holder: HomeTabViewPagerViewHolder, position: Int) {
            holder.onBind(_data[position])
        }

        override fun getItemCount(): Int {
            return _data.size
        }

    }

    class HomeTodayGoAdapter : ListAdapter<HomeTodayGoInfo, HomeTodayGoAdapter.HomeTodayGoViewHolder>(HomeTodayGoDiffUtil) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTodayGoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemHomeTodayDeliveryBinding.inflate(layoutInflater, parent, false)
            return HomeTodayGoViewHolder(binding)
        }

        override fun onBindViewHolder(holder: HomeTodayGoViewHolder, position: Int) {
            holder.onGoBind(getItem(position))
        }

        class HomeTodayGoViewHolder(private val binding: ItemHomeTodayDeliveryBinding) :
                RecyclerView.ViewHolder(binding.root) {
            fun onGoBind(homeTodayGoInfo: HomeTodayGoInfo) {
                binding.ivTodayDeliveryImg.setImageResource(homeTodayGoInfo.homeTodayImage)
                binding.ivSelectorHeartEmpty.setImageResource(homeTodayGoInfo.homeTodayHeart)
                binding.tvIntense.text = homeTodayGoInfo.homeTodayIntense
                binding.tvTodayName.text = homeTodayGoInfo.homeTodayName
                binding.tvZDiscount.text = homeTodayGoInfo.homeTodayDis
                binding.tvPrice.text = homeTodayGoInfo.homeTodayPrice
                binding.tvPercent.text = homeTodayGoInfo.homeTodayPercent
                binding.tvPriceX.text = homeTodayGoInfo.homeTodayPrice_x
                binding.freeShipping.setImageResource(homeTodayGoInfo.homeTodayFreeShipping)
                if (!homeTodayGoInfo.GoQuestion) {
                    binding.ivTodayGo.visibility = View.INVISIBLE
                } else {
                    binding.ivTodayGo.setImageResource(homeTodayGoInfo.homeTodayGo)
                }
            }
        }

        object HomeTodayGoDiffUtil : DiffUtil.ItemCallback<HomeTodayGoInfo>(){
            override fun areItemsTheSame(oldItem: HomeTodayGoInfo, newItem: HomeTodayGoInfo): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: HomeTodayGoInfo, newItem: HomeTodayGoInfo): Boolean {
                return oldItem == newItem
            }
        }
    }
}

