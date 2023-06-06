package com.example.kocsistemcase.ui.track

import android.content.Intent
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.kocsistemcase.R
import com.example.kocsistemcase.databinding.FragmentTrackBinding
import com.example.kocsistemcase.ui.detail.DetailActivity
import com.example.kocsistemcase.ui.adapter.TrackAdapter
import com.example.kocsistemcase.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TrackFragment(
) : BaseFragment<TrackViewModel, FragmentTrackBinding>() {

    override val layoutId: Int = R.layout.fragment_track
    override val viewModelClass: Class<TrackViewModel> = TrackViewModel::class.java
    override fun initUI() {
        val trackAdapter = TrackAdapter(onItemClick = {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("trackId",it.trackId)
            startActivity(intent)

        })
        binding.rvTrackList.adapter = trackAdapter

        viewModel.trackMusicList.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                trackAdapter.setData(it)
                binding.progress.visibility = View.GONE
            }
        }

    }

}