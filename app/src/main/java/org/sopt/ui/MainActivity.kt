package org.sopt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.R
import org.sopt.databinding.ActivityMainBinding
import org.sopt.ui.view.empty.EmptyFragment
import org.sopt.ui.view.home.HomeFragment
import org.sopt.ui.view.store.StoreFragment
import org.sopt.util.replace

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    private val homeFragment: HomeFragment by lazy { HomeFragment() }
    private val storeFragment: StoreFragment by lazy { StoreFragment() }
    private val emptyFragment: EmptyFragment by lazy { EmptyFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        replaceHomeFragment()
        initBottomNavigation()

        setContentView(binding.root)
    }

    private fun initBottomNavigation() {
        binding.apply {
            bnvMain.itemIconTintList = null

            bnvMain.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_home -> {
                        replaceHomeFragment()
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.menu_store -> {
                        replaceStoreFragment()
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.menu_moa -> {
                        replaceEmptyFragment()
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.menu_heart -> {
                        replaceEmptyFragment()
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.menu_my_page -> {
                        replaceEmptyFragment()
                        return@setOnNavigationItemSelectedListener true
                    }
                }
                false
            }
        }
    }

    private fun replaceHomeFragment() {
        replace(R.id.container_main, homeFragment)
    }

    private fun replaceStoreFragment() {
        replace(R.id.container_main, storeFragment)
    }

    private fun replaceEmptyFragment() {
        replace(R.id.container_main, emptyFragment)
    }
}