package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.databinding.ItemHomeThisItemTwoBinding
import org.sopt.ui.view.home.model.HomeThisItemTwoInfo

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
                    if (!GoThisItemTwoQuestion)
                        ivThisTwoTodayGo.visibility = View.INVISIBLE
                    else
                        ivThisTwoTodayGo.setImageResource(homeThisItemTwoGo)

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