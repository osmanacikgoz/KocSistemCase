package com.example.kocsistemcase.ui.track_grid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kocsistemcase.databinding.FragmentTrackGridBinding

class TrackGridFragment : Fragment() {
    private lateinit var binding: FragmentTrackGridBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrackGridBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}