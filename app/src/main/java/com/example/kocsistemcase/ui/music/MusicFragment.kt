package com.example.kocsistemcase.ui.music

import android.content.Intent
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.kocsistemcase.R
import com.example.kocsistemcase.databinding.FragmentMusicBinding
import com.example.kocsistemcase.ui.DetailActivity
import com.example.kocsistemcase.ui.adapter.MusicPagingAdapter
import com.example.kocsistemcase.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MusicFragment : BaseFragment<MusicViewModel, FragmentMusicBinding>() {

    override val layoutId: Int = R.layout.fragment_music

    override val viewModelClass: Class<MusicViewModel> = MusicViewModel::class.java

    override fun initUI() {
        val musicPagingAdapter = MusicPagingAdapter(onItemClick = {
            val intent = Intent(requireContext(),DetailActivity::class.java)
            intent.putExtra("trackId",it.trackId)
            startActivity(intent)

        })
        binding.rvMusicList.adapter = musicPagingAdapter

        viewModel.musicResponse.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                musicPagingAdapter.submitData(it)
                binding.progress.visibility = View.GONE
            }
        }
    }

}