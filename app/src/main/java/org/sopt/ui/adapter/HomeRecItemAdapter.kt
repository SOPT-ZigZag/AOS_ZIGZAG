package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.databinding.ItemHomeRecItemBinding
import org.sopt.remote.model.ResItem
import org.sopt.ui.view.home.model.HomeRecItemInfo

class HomeRecItemAdapter : RecyclerView.Adapter<HomeRecItemAdapter.HomeRecItemViewHolder>() {
    private val _data = mutableListOf<ResItem.Data.Item>()
    var data: List<ResItem.Data.Item> = _data
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
        fun onRecBind (resItem : ResItem.Data.Item) {
            binding.apply {
                Glide.with(ivRcImage.context)
                    .load(resItem.img)
                tvIntense2.text = resItem.brand_name
                tvRcItemName.text = resItem.item_name
                tvRcPrice.text = resItem.price.toString()
                tvRcPercent.text = "20%"
                tvRcItemDiscount.text = resItem.discount_idx.toString()
                tvRcPrice2.text = "15000"
                if (!resItem.delivery_today) {
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
        holder.onRecBind(_data[position])
    }
}