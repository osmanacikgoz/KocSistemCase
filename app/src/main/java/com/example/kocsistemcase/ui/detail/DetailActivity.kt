package com.example.kocsistemcase.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kocsistemcase.databinding.ActivityDetailBinding
import com.example.kocsistemcase.util.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trackId = intent.extras?.getInt("trackId")
        trackId?.let {safeTrackId->
            getMusicDetail(trackId = safeTrackId)
        }
    }

    private fun getMusicDetail(trackId: Int) {
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.getMusicDetail(trackId).collect{musicEntity->
                    with(binding){
                        musicImages.loadImage(musicEntity.artworkUrl100)
                        musicName.text = musicEntity.trackName
                        artistName.text = musicEntity.artistName
                        albumName.text = musicEntity.collectionCensoredName
                        releaseDate.text = musicEntity.releaseDate
                        price.text = musicEntity.collectionPrice.toString()
                }
            }
        }
    }
}