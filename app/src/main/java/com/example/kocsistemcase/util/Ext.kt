package com.example.kocsistemcase.util

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Activity.showFragment(resContainerId: Int, fragment: Fragment) {
    when (this) {
        is AppCompatActivity -> {
            supportFragmentManager.beginTransaction().apply {
                replace(resContainerId, fragment)
                    .addToBackStack(fragment.tag)
                commit()
            }
        }
    }
}