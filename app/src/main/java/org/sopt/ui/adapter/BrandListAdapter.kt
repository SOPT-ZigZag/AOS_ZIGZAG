package org.sopt.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.R
import org.sopt.databinding.ItemStoreBinding
import org.sopt.remote.model.ResShoppingMall
import org.sopt.ui.view.store.data.model.BrandData
import org.sopt.util.setImage

class BrandListAdapter : RecyclerView.Adapter<BrandListAdapter.BrandViewHolder>() {
    private val _data = mutableListOf<ResShoppingMall>()
    private var viewType = ALL_BRAND
    var data : List<ResShoppingMall> = _data
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
        fun bind(resShoppingMall: ResShoppingMall, position: Int) {
            binding.apply {
                with(resShoppingMall.data) {
                    if(getItemViewType(position) == Z_ONLY) {
                        //if(!zOnly)
                            //clStore.visibility = View.GONE
                    }

                    tvNum.text = (position + 1).toString()
                    tvStore.text = brand
                    tvType.text = style
                    tvCoupon.text = coupon.toString()
                    //tvFollower.text =
                    setImage(ivCircleStore, img)

                    /*if (!zOnly)
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
                    }*/
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
