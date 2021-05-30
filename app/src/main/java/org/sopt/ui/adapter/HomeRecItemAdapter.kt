package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.databinding.ItemHomeRecItemBinding
import org.sopt.ui.view.home.model.HomeRecItemInfo

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
                tvIntense2.text = homeRecItemInfo.recItemIntense
                tvRcItemName.text = homeRecItemInfo.recItemName
                tvRcPrice.text = homeRecItemInfo.recItemPrice
                tvRcPercent.text = homeRecItemInfo.recItemPercent
                tvRcItemDiscount.text = homeRecItemInfo.recItemDis
                tvRcPrice2.text = homeRecItemInfo.recItemPrice_2
                if (!homeRecItemInfo.recTodayGo_2) {
                    ivThisTodayGo.visibility = View.INVISIBLE
                } else {
                    ivThisTodayGo.visibility = View.VISIBLE
                }

                with(ivPinkHeart) {
                    isSelected = false
                    setOnClickListener { it.isSelected = !it.isSelected }
                }

                with(ivBasket) {
                    isSelected = false
                    setOnClickListener { it.isSelected = !it.isSelected }
                }
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