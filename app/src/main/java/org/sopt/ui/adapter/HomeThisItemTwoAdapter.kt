package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.databinding.ItemHomeThisItemTwoBinding
import org.sopt.remote.model.ResItem
import org.sopt.ui.view.home.model.HomeThisItemTwoInfo

class HomeThisItemTwoAdapter : RecyclerView.Adapter<HomeThisItemTwoAdapter.HomeThisItemTwoViewHolder>() {
    private val _data = mutableListOf<ResItem.Data.Item>()
    var data: List<ResItem.Data.Item> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }



    class HomeThisItemTwoViewHolder(private val binding: ItemHomeThisItemTwoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onThisBind(resItem: ResItem.Data.Item) {
            binding.apply {
                with(resItem) {
                    Glide.with(ivThisItemTwo.context)
                        .load(resItem.img)
                        .into(ivThisItemTwo)
                    tvThisIntenseTwo.text = brand_name
                    tvThisTodayNameTwo.text = item_name
                    tvThisPercentTwo.text = discount_idx.toString()
                    tvThisPriceXTwo.text = "15000"
                    if (!delivery_today)
                        ivThisTwoTodayGo.visibility = View.INVISIBLE
                    else
                        ivThisTwoTodayGo.visibility = View.VISIBLE

                    ivSelectorHeartEmpty3.setOnClickListener { it.isSelected = !it.isSelected }
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeThisItemTwoAdapter.HomeThisItemTwoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeThisItemTwoBinding.inflate(layoutInflater, parent, false)
        return HomeThisItemTwoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeThisItemTwoViewHolder, position: Int) {
        holder.onThisBind(_data[position])
    }

    override fun getItemCount(): Int {
       return _data.size
    }
}