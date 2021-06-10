package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.R
import org.sopt.databinding.ItemHomeTabImageBinding
import org.sopt.remote.model.ResBanner
import org.sopt.ui.view.home.model.HomeTabViewPagerImage

class HomeTabViewPagerAdapter : RecyclerView.Adapter<HomeTabViewPagerAdapter.HomeTabViewPagerViewHolder>() {
    private val _data = mutableListOf<ResBanner>()
    var data: List<ResBanner> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    class HomeTabViewPagerViewHolder(private val binding: ItemHomeTabImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(resBanner: ResBanner) {
            Glide.with(binding.ivHomeTabImage.context)
                .load(resBanner.data.img)
                .into(binding.ivHomeTabImage)
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