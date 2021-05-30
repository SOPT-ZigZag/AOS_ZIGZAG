package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.databinding.ItemHomeTabImageBinding
import org.sopt.ui.view.home.model.HomeTabViewPagerImage

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