package com.example.kocsistemcase.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kocsistemcase.databinding.ActivityDetailBinding
import com.example.kocsistemcase.util.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trackId = intent.extras?.getInt("trackId")
        getMusicDetail(trackId)
        getDetail()
    }

    private fun getMusicDetail(trackId: Int?) {
        trackId?.let {
            viewModel.musicDetail(it)
        }
    }
    private fun getDetail() {
        viewModel.musicDetail.let {
            binding.apply {
                musicImages.loadImage(it.value?.artworkUrl100)
                musicName.text = it.value?.trackName
                artistName.text = it.value?.artistName
                albumName.text = it.value?.collectionCensoredName
                releaseDate.text = it.value?.releaseDate
                price.text = it.value?.collectionPrice.toString()

            }
        }
    }
}