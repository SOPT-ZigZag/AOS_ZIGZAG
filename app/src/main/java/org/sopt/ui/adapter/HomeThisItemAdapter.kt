package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.databinding.ItemHomeThisItemBinding
import org.sopt.remote.model.ResItem
import org.sopt.ui.view.home.model.HomeThisItemInfo
import org.sopt.util.NumberUtil.convertIntToMoneyString

class HomeThisItemAdapter : RecyclerView.Adapter<HomeThisItemAdapter.HomeThisItemViewHolder>() {

    private val _data = mutableListOf<ResItem.Data.Item>()
    var data: List<ResItem.Data.Item> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }


    class HomeThisItemViewHolder(private val binding: ItemHomeThisItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onThisBind(resItem : ResItem.Data.Item) {
            binding.apply {
                with(resItem) {
                    Glide.with(ivThisItem.context)
                        .load(resItem.img)
                        .into(ivThisItem)
                    tvThisIntense.text = brand_name
                    tvThisTodayName.text = item_name
                    tvThisZDiscount.text = "제트할인가"
                    tvThisPercent.text = "72%"
                    tvThisPrice.text = convertIntToMoneyString(price)
                    tvThisPriceX.text = convertIntToMoneyString(15000)

                    when(delivery_today) {
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