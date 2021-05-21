package org.sopt.ui.adapter

import android.media.browse.MediaBrowser
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import org.sopt.databinding.*
import org.sopt.ui.view.home.model.*
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


    class HomeTodayGoAdapter : RecyclerView.Adapter<HomeTodayGoAdapter.HomeTodayGoViewHolder>() {
        private val _data = mutableListOf<HomeTodayGoInfo>()
        private var viewType = ALL_BRAND
        var data: List<HomeTodayGoInfo> = _data
            set(value) {
                _data.clear()
                _data.addAll(value)
                notifyDataSetChanged()
            }


        fun setItemViewType(type: Int) {
            viewType = type
            notifyDataSetChanged()
        }

        override fun getItemViewType(position: Int): Int {
            return viewType
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTodayGoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemHomeTodayDeliveryBinding.inflate(layoutInflater, parent, false)
            return HomeTodayGoViewHolder(binding)
        }

        override fun onBindViewHolder(holder: HomeTodayGoViewHolder, position: Int) {
            holder.onGoBind(data[position], position)
        }

        override fun getItemCount(): Int {
            return _data.size
        }

        inner class HomeTodayGoViewHolder(private val binding: ItemHomeTodayDeliveryBinding) :
                RecyclerView.ViewHolder(binding.root) {
            fun onGoBind(homeTodayGoInfo: HomeTodayGoInfo, position: Int) {
                binding.apply {
                    if (getItemViewType(position) == TODAY_GO) {
                        if (!homeTodayGoInfo.GoQuestion) {
                            binding.clHomeDelivery.visibility = View.GONE
                        }
                    }


                    ivTodayDeliveryImg.setImageResource(homeTodayGoInfo.homeTodayImage)
                    ivSelectorHeartEmpty.setImageResource(homeTodayGoInfo.homeTodayHeart)
                    tvIntense.text = homeTodayGoInfo.homeTodayIntense
                    tvTodayName.text = homeTodayGoInfo.homeTodayName
                    tvZDiscount.text = homeTodayGoInfo.homeTodayDis
                    tvPrice.text = homeTodayGoInfo.homeTodayPrice
                    tvPercent.text = homeTodayGoInfo.homeTodayPercent
                    tvPriceX.text = homeTodayGoInfo.homeTodayPrice_x
                    ivFreeShipping.setImageResource(homeTodayGoInfo.homeTodayFreeShipping)
                    if (!homeTodayGoInfo.GoQuestion) {
                        ivTodayGo.visibility = View.INVISIBLE
                    } else {
                        ivTodayGo.setImageResource(homeTodayGoInfo.homeTodayGo)
                    }
                    ivSelectorHeartEmpty.setOnClickListener { it.isSelected = !it.isSelected }
                }
            }
        }

        companion object {
            const val ALL_BRAND = 0
            const val TODAY_GO = 1
        }
    }

    class HomeRecItemAdapter : RecyclerView.Adapter<HomeRecItemAdapter.HomeRecItemViewHolder>() {
        private val _data = mutableListOf<HomeRecItemInfo>()
        var data: List<HomeRecItemInfo> = _data
            set(value) {
                _data.clear()
                _data.addAll(value)
                notifyDataSetChanged()
            }

        override fun getItemCount(): Int {
            return _data.size
        }

        class HomeRecItemViewHolder(private val binding: ItemHomeRecItemBinding) :
                RecyclerView.ViewHolder(binding.root) {
            fun onRecBind(homeRecItemInfo: HomeRecItemInfo) {
                binding.apply {
                    ivRcImage.setImageResource(homeRecItemInfo.recItemImage)
                    ivPinkHeart.setImageResource(homeRecItemInfo.recItemPinkHeart)
                    tvIntense2.text = homeRecItemInfo.recItemIntense
                    tvRcItemName.text = homeRecItemInfo.recItemName
                    tvRcPrice.text = homeRecItemInfo.recItemPrice
                    tvRcPercent.text = homeRecItemInfo.recItemPercent
                    tvRcItemDiscount.text = homeRecItemInfo.recItemDis
                    tvRcPrice2.text = homeRecItemInfo.recItemPrice_2
                    ivFreeShipping2.setImageResource(homeRecItemInfo.recItemFreeShipping)
                    ivBasket.setImageResource(homeRecItemInfo.recItemBasket)
                    if (!homeRecItemInfo.recTodayGo_2) {
                        ivThisTodayGo.visibility = View.INVISIBLE
                    } else {
                        ivThisTodayGo.setImageResource(homeRecItemInfo.recItemGo)
                    }

                    ivPinkHeart.setOnClickListener { it.isSelected = !it.isSelected }
                    ivBasket.setOnClickListener { it.isSelected = !it.isSelected }
                }
            }


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemHomeRecItemBinding.inflate(layoutInflater, parent, false)
            return HomeRecItemViewHolder(binding)
        }

        override fun onBindViewHolder(holder: HomeRecItemViewHolder, position: Int) {
            holder.onRecBind(data[position])
        }
    }

    class HomeThisItemAdapter : ListAdapter<HomeThisItemInfo, HomeThisItemAdapter.HomeThisItemViewHolder>(HomeThisItemAdapter.HomeThisItemViewHolder.HomeThisItemDiffUtil) {


        class HomeThisItemViewHolder(private val binding: ItemHomeThisItemBinding) :
                RecyclerView.ViewHolder(binding.root) {
            fun onThisBind(homeThisItem: HomeThisItemInfo) {
                binding.apply {
                    ivThisItem.setImageResource(homeThisItem.homeThisItemImage)
                    ivSelectorHeartEmpty2.setImageResource(homeThisItem.homeThisItemHeart)
                    tvThisIntense.text = homeThisItem.homeThisItemIntense
                    tvThisTodayName.text = homeThisItem.homeThisItemName
                    tvThisZDiscount.text = homeThisItem.homeThisItemDis
                    tvThisPercent.text = homeThisItem.homeThisItemPercent
                    tvThisPrice.text = homeThisItem.homeThisItemPrice
                    tvThisPriceX.text = homeThisItem.homeThisItemPrice_x
                    ivThisFreeShipping.setImageResource(homeThisItem.homeThisItemFreeShipping)
                    if (!homeThisItem.GoThisItemQuestion) {
                        ivThisTodayGo.visibility = View.INVISIBLE
                    } else {
                        ivThisTodayGo.setImageResource(homeThisItem.homeThisItemGo)
                    }
                }
            }

            object HomeThisItemDiffUtil : DiffUtil.ItemCallback<HomeThisItemInfo>() {
                override fun areItemsTheSame(oldItem: HomeThisItemInfo, newItem: HomeThisItemInfo): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }


                override fun areContentsTheSame(oldItem: HomeThisItemInfo, newItem: HomeThisItemInfo): Boolean {
                    return oldItem == newItem
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeThisItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemHomeThisItemBinding.inflate(layoutInflater, parent, false)
            return HomeThisItemViewHolder(binding)
        }

        override fun onBindViewHolder(holder: HomeThisItemViewHolder, position: Int) {
            holder.onThisBind(getItem(position))
        }
    }

    class HomeThisItemTwoAdapter : ListAdapter<HomeThisItemTwoInfo, HomeThisItemTwoAdapter.HomeThisItemTwoViewHolder>(HomeThisItemTwoViewHolder.HomeThisItemTwoDiffUtil) {


        class HomeThisItemTwoViewHolder(private val binding: ItemHomeThisItemTwoBinding) :
                RecyclerView.ViewHolder(binding.root) {
            fun onThisBind(homeThisItemTwo: HomeThisItemTwoInfo) {
                binding.apply {
                    with(homeThisItemTwo) {
                        ivThisItemTwo.setImageResource(homeThisItemTwoImage)
                        ivSelectorHeartEmpty3.setImageResource(homeThisItemTwoHeart)
                        tvThisIntenseTwo.text = homeThisItemTwoIntense
                        tvThisTodayNameTwo.text = homeThisItemTwoName
                        tvThisPercentTwo.text = homeThisItemTwoPercent
                        tvThisPriceXTwo.text = homeThisItemTwoPrice_x
                        ivThisFreeShippingTwo.setImageResource(homeThisItemTwoFreeShipping)
                        if (!GoThisItemTwoQuestion) {
                            ivThisTwoTodayGo.visibility = View.INVISIBLE
                        } else {
                            ivThisTwoTodayGo.setImageResource(homeThisItemTwoGo)
                        }
                        ivSelectorHeartEmpty3.setOnClickListener { it.isSelected = !it.isSelected }
                    }
                }
            }

            object HomeThisItemTwoDiffUtil : DiffUtil.ItemCallback<HomeThisItemTwoInfo>() {
                override fun areItemsTheSame(oldItem: HomeThisItemTwoInfo, newItem: HomeThisItemTwoInfo): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }


                override fun areContentsTheSame(oldItem: HomeThisItemTwoInfo, newItem: HomeThisItemTwoInfo): Boolean {
                    return oldItem == newItem
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeThisItemTwoAdapter.HomeThisItemTwoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemHomeThisItemTwoBinding.inflate(layoutInflater, parent, false)
            return HomeThisItemTwoViewHolder(binding)
        }

        override fun onBindViewHolder(holder: HomeThisItemTwoAdapter.HomeThisItemTwoViewHolder, position: Int) {
            holder.onThisBind(getItem(position))
        }
    }
}


