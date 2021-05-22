package org.sopt.ui.view.story

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import org.sopt.databinding.ActivityStoryBinding
import org.sopt.ui.view.store.StoreFragment

class StoryActivity : AppCompatActivity() {
    lateinit var binding : ActivityStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.progressBar.max = 1000

        val currentProgress = 1000

        ObjectAnimator.ofInt(binding.progressBar,"progress",currentProgress)
            .setDuration(15000)
            .start()



        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 15000)

        val picIntent: Intent = getIntent()
        binding.Ellipsepic.setImageResource(picIntent.getIntExtra("img",1))



        binding.closeStroyBtn.setOnClickListener {
            finish()
        }
    }
}