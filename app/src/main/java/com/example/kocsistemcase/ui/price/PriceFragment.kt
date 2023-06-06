package com.example.kocsistemcase.ui.price

import android.content.Intent
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.kocsistemcase.R
import com.example.kocsistemcase.databinding.FragmentPriceBinding
import com.example.kocsistemcase.ui.adapter.PriceMusicAdapter
import com.example.kocsistemcase.ui.base.BaseFragment
import com.example.kocsistemcase.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PriceFragment() : BaseFragment<PriceViewModel, FragmentPriceBinding>() {
    override val layoutId: Int = R.layout.fragment_price
    override val viewModelClass: Class<PriceViewModel> = PriceViewModel::class.java

    override fun initUI() {
        val priceAdapter = PriceMusicAdapter(onItemClick = { musicEntity, isRemove ->
            if (isRemove) {
                lifecycleScope.launch (Dispatchers.IO){
                    viewModel.deleteMusic(musicEntity=musicEntity)
                }

            } else {
                val intent = Intent(requireContext(), DetailActivity::class.java)
                intent.putExtra("trackId", musicEntity.trackId)
                startActivity(intent)
            }
        })

        binding.rvPriceList.adapter = priceAdapter

        viewModel.priceMusicList.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                priceAdapter.setData(ArrayList(it))
                binding.progress.visibility = View.GONE
            }
        }
    }
}