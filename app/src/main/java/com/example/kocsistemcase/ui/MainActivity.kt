package com.example.kocsistemcase.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kocsistemcase.R
import com.example.kocsistemcase.databinding.ActivityMainBinding
import com.example.kocsistemcase.ui.artist.ArtistFragment
import com.example.kocsistemcase.ui.price.PriceFragment
import com.example.kocsistemcase.ui.track.TrackFragment
import com.example.kocsistemcase.ui.track_grid.TrackGridFragment
import com.example.kocsistemcase.util.PageType
import com.example.kocsistemcase.util.showFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var artistFragment: Fragment? = null
    private var trackFragment: Fragment? = null
    private var trackGridFragment: Fragment? = null
    private var priceFragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializedUI()
        setNavBarItemSelectedListener()
    }

    private fun initializedUI() {
        setCurrentFragment(PageType.ARTIST)
    }

    private fun setNavBarItemSelectedListener() {
        binding.apply {
            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.artist -> {
                        setCurrentFragment(PageType.ARTIST)
                    }
                    R.id.track -> {
                        setCurrentFragment(PageType.TRACK)
                    }
                    R.id.trackGrid -> {
                        setCurrentFragment(PageType.TRACK_GRID)
                    }
                    R.id.prices-> {
                        setCurrentFragment(PageType.PRICE)
                    }
                }
                true
            }
        }

    }

    private fun setCurrentFragment(pageType: PageType) {
        val selectedFragment = when (pageType) {
            PageType.ARTIST -> {
                artistFragment ?: ArtistFragment()
            }
            PageType.TRACK -> {
                trackFragment ?: TrackFragment()
            }
            PageType.TRACK_GRID -> {
                trackGridFragment ?: TrackGridFragment()
            }
            PageType.PRICE -> {
                priceFragment ?: PriceFragment()
            }
        }
        showFragment(R.id.flFragment, selectedFragment)

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}