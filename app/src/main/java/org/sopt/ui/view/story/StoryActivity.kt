package org.sopt.ui.view.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {
    lateinit var binding : ActivityStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}