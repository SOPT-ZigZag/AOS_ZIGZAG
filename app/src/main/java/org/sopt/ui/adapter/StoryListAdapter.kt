package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.databinding.ItemStoryBinding
import org.sopt.remote.model.ResStory
import org.sopt.ui.view.store.data.model.StoryData
import org.sopt.util.setImage

class StoryListAdapter : RecyclerView.Adapter<StoryListAdapter.StoryViewHolder>() {
    private var storyButtonClickListener: ((String, String)-> Unit) ?= null
    private val _data = mutableListOf<ResStory>()
    var data : List<ResStory> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    fun setStoryButtonClickListener(listener : (String, String)-> Unit) {
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

        fun bind(resStory: ResStory) {
            binding.apply {
                with(resStory.data) {
                    tvBrand.text = brand
                    tvView.text = view.toString()
                    setImage(ivStory, img)
                    setImage(ivSmallStory, img)
                    ivSmallStory.setOnClickListener { storyButtonClickListener?.invoke(img, brand) }
                }
            }
        }
    }
}