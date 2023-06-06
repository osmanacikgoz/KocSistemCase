package com.example.kocsistemcase.ui.track_grid

import android.content.Intent
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.kocsistemcase.R
import com.example.kocsistemcase.databinding.FragmentTrackGridBinding
import com.example.kocsistemcase.ui.detail.DetailActivity
import com.example.kocsistemcase.ui.adapter.TrackGridAdapter
import com.example.kocsistemcase.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TrackGridFragment : BaseFragment<TrackGridViewModel, FragmentTrackGridBinding>() {
    override val layoutId: Int = R.layout.fragment_track_grid
    override val viewModelClass: Class<TrackGridViewModel> = TrackGridViewModel::class.java

    override fun initUI() {

        val trackGridAdapter = TrackGridAdapter(onItemClick = {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("trackId", it.trackId)
            startActivity(intent)
        })
        binding.rvgridTrackList.adapter = trackGridAdapter

        viewModel.trackMusicList.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                trackGridAdapter.setData(it)
                binding.progress.visibility = View.GONE
            }
        }

    }

}