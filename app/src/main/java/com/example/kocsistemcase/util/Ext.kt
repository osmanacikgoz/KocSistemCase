package com.example.kocsistemcase.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kocsistemcase.R

fun ImageView.loadImage(
    url: String?,
    @DrawableRes placeholderDrawableRes: Int = R.drawable.baseline_music_note_24,
    @DrawableRes errorDrawableRes: Int = R.drawable.baseline_music_note_24
) {
    val requestOptions =
        RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).error(errorDrawableRes)

    Glide.with(this).load(url).placeholder(placeholderDrawableRes).apply(requestOptions)
        .into(this)
}