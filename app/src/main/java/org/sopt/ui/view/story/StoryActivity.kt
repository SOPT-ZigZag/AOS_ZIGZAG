package org.sopt.ui.view.story

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import org.sopt.R
import org.sopt.databinding.ActivityStoryBinding
import org.sopt.ui.view.store.StoreFragment.Companion.BRAND_NAME
import org.sopt.ui.view.store.StoreFragment.Companion.IMG

class StoryActivity : AppCompatActivity() {
    lateinit var binding : ActivityStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initProgressBar()
        setHandler()
        setStory()
        initClickEvent()
    }

    private fun initProgressBar() {
        binding.apply {
            progressBar.max = PROGRESS_SIZE

            ObjectAnimator.ofInt(progressBar, "progress", PROGRESS_SIZE)
                .setDuration(STORY_TIME)
                .start()
        }
    }

    private fun setHandler() {
        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, STORY_TIME)
    }

    private fun setStory() {
        val storyImage = intent.getIntExtra(IMG, R.drawable.img_moderntage_1)
        val brandName = intent.getStringExtra(BRAND_NAME)

        binding.apply {
            ivStory.setImageResource(storyImage)
            ivCircleStory.setImageResource(storyImage)
            tvStore.text = brandName
        }
    }

    private fun initClickEvent() { binding.btnCloseStroy.setOnClickListener { finish() } }

    companion object {
        const val STORY_TIME = 15000L
        const val PROGRESS_SIZE = 1000
    }
}