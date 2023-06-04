package com.example.kocsistemcase.util

import android.app.Activity
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun Activity.showFragment(resContainerId: Int, fragment: Fragment) {
    when (this) {
        is AppCompatActivity -> {
            supportFragmentManager.beginTransaction().apply {
                replace(resContainerId, fragment)
                    .addToBackStack(fragment.tag)
                commit()
            }
        }
    }
}

fun ImageView.loadImage(imageUrl: String?) {
    imageUrl?.let {
        Glide.with(context).load(imageUrl).into(this)
    }
}

fun ImageView.loadImageDrawable(images:Int) {
    images.let {
        Glide.with(context).load(images).into(this)
    }
}