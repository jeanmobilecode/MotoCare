package com.example.motocare.utils

import android.view.View
import androidx.fragment.app.Fragment
import com.example.motocare.HomeActivity

fun Fragment.setCardClickListener(cardView: View, fragment: Fragment) {
    cardView.setOnClickListener {
        (activity as? HomeActivity)?.replaceFragment(fragment)
    }
}