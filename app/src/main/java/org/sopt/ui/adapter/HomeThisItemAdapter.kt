package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.databinding.ItemHomeThisItemBinding
import org.sopt.ui.view.home.model.HomeThisItemInfo

class HomeThisItemAdapter : RecyclerView.Adapter<HomeThisItemAdapter.HomeThisItemViewHolder>() {

    private val _data = mutableListOf<HomeThisItemInfo>()
    var data: List<HomeThisItemInfo> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }


    class HomeThisItemViewHolder(private val binding: ItemHomeThisItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onThisBind(homeThisItem: HomeThisItemInfo) {
            binding.apply {
                with(homeThisItem) {
                    ivThisItem.setImageResource(homeThisItemImage)
                    tvThisIntense.text = homeThisItemIntense
                    tvThisTodayName.text = homeThisItemName
                    tvThisZDiscount.text = homeThisItemDis
                    tvThisPercent.text = homeThisItemPercent
                    tvThisPrice.text = homeThisItemPrice
                    tvThisPriceX.text = homeThisItemPrice_x

                    when(GoThisItemQuestion) {
                        true -> ivThisTodayGo.visibility = View.VISIBLE
                        false -> ivThisTodayGo.visibility = View.INVISIBLE
                    }
                }

                with(ivSelectorHeartEmpty2) {
                    isSelected = false
                    setOnClickListener { it.isSelected = !it.isSelected }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeThisItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeThisItemBinding.inflate(layoutInflater, parent, false)
        return HomeThisItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeThisItemViewHolder, position: Int) {
        holder.onThisBind(_data[position])
    }
}