package org.sopt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.databinding.ItemStoryBinding
import org.sopt.remote.model.ResStory
import org.sopt.util.NumberUtil.convertIntToDecimalString
import org.sopt.util.setImage

class StoryListAdapter : RecyclerView.Adapter<StoryListAdapter.StoryViewHolder>() {
    private var storyButtonClickListener: ((String, String)-> Unit) ?= null
    private val _data = mutableListOf<ResStory.Data.Story>()
    var data : List<ResStory.Data.Story> = _data
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

        fun bind(resStory: ResStory.Data.Story) {
            binding.apply {
                with(resStory) {
                    setImage(ivStory, img)
                    ivStory.setOnClickListener { storyButtonClickListener?.invoke(img, brand) }
                }
            }
        }
    }
}