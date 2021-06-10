package org.sopt.util

import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

fun AppCompatActivity.replace(@IdRes frameId: Int, fragment: androidx.fragment.app.Fragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(frameId, fragment, null)
        .commit()
}

fun setImage(imageView: ImageView, url:String) {
    Glide.with(imageView.context).load(url).into(imageView)
}