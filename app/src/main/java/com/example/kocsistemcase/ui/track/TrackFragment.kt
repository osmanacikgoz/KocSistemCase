package com.example.kocsistemcase.ui.track

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kocsistemcase.databinding.FragmentTrackBinding

class TrackFragment : Fragment() {
    private lateinit var binding: FragmentTrackBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrackBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}