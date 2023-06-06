package com.example.kocsistemcase.ui.price

import android.content.Intent
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.kocsistemcase.R
import com.example.kocsistemcase.databinding.FragmentPriceBinding
import com.example.kocsistemcase.ui.detail.DetailActivity
import com.example.kocsistemcase.ui.adapter.PriceMusicAdapter
import com.example.kocsistemcase.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PriceFragment(

) : BaseFragment<PriceViewModel, FragmentPriceBinding>() {
    override val layoutId: Int = R.layout.fragment_price
    override val viewModelClass: Class<PriceViewModel> = PriceViewModel::class.java
    override fun initUI() {
        val priceAdapter = PriceMusicAdapter(onItemClick = {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("trackId",it.trackId)
            startActivity(intent)
        })

        binding.rvPriceList.adapter = priceAdapter

        viewModel.priceMusicList.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                priceAdapter.setData(it)
                binding.progress.visibility = View.GONE
            }
        }

    }


}