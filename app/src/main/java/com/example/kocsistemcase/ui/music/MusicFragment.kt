package com.example.kocsistemcase.ui.music

import androidx.lifecycle.lifecycleScope
import com.example.kocsistemcase.R
import com.example.kocsistemcase.databinding.FragmentMusicBinding
import com.example.kocsistemcase.ui.adapter.MusicPagingAdapter
import com.example.kocsistemcase.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MusicFragment(
    override val layoutId: Int = R.layout.fragment_music,
    override val viewModelClass: Class<MusicViewModel> = MusicViewModel::class.java
) : BaseFragment<MusicViewModel, FragmentMusicBinding>() {
    override fun initUI() {
        val musicPagingAdapter = MusicPagingAdapter(onItemClick = {

        })
        binding.musicList.adapter = musicPagingAdapter

        viewModel.musicResponse.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                musicPagingAdapter.submitData(it)
            }
        }
    }

}