package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.databinding.ItemHomeTodayDeliveryBinding
import org.sopt.remote.model.ResItem
import org.sopt.ui.view.home.model.HomeTodayGoInfo
import org.sopt.util.NumberUtil
import org.sopt.util.NumberUtil.convertIntToMoneyString

class HomeTodayGoAdapter : RecyclerView.Adapter<HomeTodayGoAdapter.HomeTodayGoViewHolder>() {
    private val _data = mutableListOf<ResItem.Data.Item>()
    private var viewType = ALL_BRAND
    var data: List<ResItem.Data.Item> = _data
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
        holder.onGoBind(_data[position], position)
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    inner class HomeTodayGoViewHolder(private val binding: ItemHomeTodayDeliveryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onGoBind(resItem: ResItem.Data.Item,  position:Int) {
            binding.apply {
                if (getItemViewType(position) == TODAY_GO && ! resItem.delivery_today)
                    clHomeDelivery.visibility = View.GONE

                with(resItem) {
                    Glide.with(ivTodayDeliveryImg.context)
                        .load(resItem.img)
                        .into(ivTodayDeliveryImg)

                    tvIntense.text = brand_name
                    tvTodayName.text = item_name
                    tvZDiscount.text = "제트할인가"
                    tvPrice.text = convertIntToMoneyString(price)
                    tvPercent.text = "72%"
                    tvPriceX.text = convertIntToMoneyString(15000)
                    when (resItem.delivery_today) {
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