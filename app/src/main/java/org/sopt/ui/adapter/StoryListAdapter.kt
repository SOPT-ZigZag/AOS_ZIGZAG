package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.databinding.ItemStoryBinding
import org.sopt.ui.view.store.data.model.StoryData

class StoryListAdapter : RecyclerView.Adapter<StoryListAdapter.StoryViewHolder>() {
    private var storyButtonClickListener: ((Int, String)-> Unit) ?= null
    private val _data = mutableListOf<StoryData>()
    var data : List<StoryData> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    fun setStoryButtonClickListener(listener : (Int, String)-> Unit) {
        this.storyButtonClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding: ItemStoryBinding = ItemStoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)

        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    override fun getItemCount(): Int = _data.size

    inner class StoryViewHolder(private val binding: ItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(storyData: StoryData) {
            binding.apply {
                with(storyData) {
                    tvBrand.text = brand
                    tvView.text = view
                    ivStory.setImageResource(img)
                    ivSmallStory.setImageResource(img)
                    ivSmallStory.setOnClickListener { storyButtonClickListener?.invoke(img, brand) }
                }
            }
        }
    }
}