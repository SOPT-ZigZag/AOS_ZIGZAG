package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.databinding.ItemHomeTodayDeliveryBinding
import org.sopt.ui.view.home.model.HomeTodayGoInfo

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
                if (getItemViewType(position) == TODAY_GO && !homeTodayGoInfo.GoQuestion)
                    clHomeDelivery.visibility = View.GONE

                with(homeTodayGoInfo) {
                    ivTodayDeliveryImg.setImageResource(homeTodayImage)
                    tvIntense.text = homeTodayIntense
                    tvTodayName.text = homeTodayName
                    tvZDiscount.text = homeTodayDis
                    tvPrice.text = homeTodayPrice
                    tvPercent.text = homeTodayPercent
                    tvPriceX.text = homeTodayPrice_x
                    when (GoQuestion) {
                        true -> ivTodayGo.visibility = View.VISIBLE
                        false -> ivTodayGo.visibility = View.INVISIBLE
                    }
                }

                ivSelectorHeartEmpty.apply {
                    isSelected = false
                    setOnClickListener { it.isSelected = !it.isSelected }
                }
            }
        }
    }

    companion object {
        const val ALL_BRAND = 0
        const val TODAY_GO = 1
    }
}