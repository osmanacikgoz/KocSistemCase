package com.example.kocsistemcase.ui.price

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kocsistemcase.databinding.FragmentPriceBinding

class PriceFragment:Fragment() {
    private lateinit var binding:FragmentPriceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPriceBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}