package org.sopt.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import org.sopt.R
import org.sopt.databinding.ItemStoreBinding
import org.sopt.ui.view.store.data.model.BrandData

class BrandListAdapter : RecyclerView.Adapter<BrandListAdapter.BrandViewHolder>() {
    private val _data = mutableListOf<BrandData>()
    private var viewType = ALL_BRAND
    var data : List<BrandData> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    fun setItemViewType(type : Int) {
        viewType = type
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val binding: ItemStoreBinding = ItemStoreBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)

        return BrandViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int = _data.size

    inner class BrandViewHolder(private val binding: ItemStoreBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(brandData: BrandData, position: Int) {
            binding.apply {
                with(brandData) {
                    if(getItemViewType(position) == Z_ONLY) {
                        if(!zOnly)
                            clStore.visibility = View.GONE
                    }

                    tvNum.text = (position + 1).toString()
                    tvStore.text = name
                    tvType.text = type
                    tvCoupon.text = coupon
                    tvFollower.text = follower
                    ivCircleStore.setImageResource(img)

                    if (!zOnly)
                        ivZOnly.visibility = View.INVISIBLE

                    if (rankChange > 0) {
                        tvFollower.text = "+$rankChange"
                        tvFollower.setTextColor(getColor(context, R.color.brand_pink))
                    } else {
                        when (rankChange) {
                            0 -> tvFollower.text = "-"
                            else -> {
                                tvFollower.text = rankChange.toString()
                                tvFollower.setTextColor(getColor(context, R.color.purple_blue))
                            }
                        }
                    }
                }

                ibStar.setOnClickListener { it.isSelected = !it.isSelected }
            }
        }
    }

    companion object {
        const val ALL_BRAND = 0
        const val Z_ONLY= 1
    }
}
