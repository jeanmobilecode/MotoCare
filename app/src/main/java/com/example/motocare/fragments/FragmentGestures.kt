package com.example.motocare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.motocare.HomeActivity
import com.example.motocare.R
import com.example.motocare.databinding.ActivityMainBinding
import com.example.motocare.databinding.FragmentGesturesBinding
import com.example.motocare.pages.Pages
import com.example.motocare.pages.PagesAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


class FragmentGestures : Fragment() {

    var _binding : FragmentGesturesBinding? = null
    val binding get() = _binding!!

    private lateinit var viewPager: ViewPager2
    private lateinit var dotsIndicator: DotsIndicator
    private lateinit var pagesList: List<Pages>
    private var LASTITEM = 4



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGesturesBinding.inflate(inflater, container, false)
        (activity as? HomeActivity)?.setToolbarTitle("Moto Gestures")

        setupViews()
        setupViewPager()

        return binding.root
    }

    private fun setupViews() {
        viewPager = binding.viewPager2
        dotsIndicator = binding.dotsIndicator

        pagesList = mutableListOf(
            Pages("Turn flashlight on and off", "Make two quick chopping motions (like swinging an axe) to turn the flashlight on or off.",R.raw.gf_turn_flash_on,true),
            Pages("Rotate the phone to open the camera", "\n" + "Instantly open your camera on any screen, even if the screen is locked, with Instant Camera.",R.raw.gf_quick_capture,true)
        )
    }

    private fun setupViewPager() {
        val adapter = PagesAdapter(pagesList)
        viewPager.adapter = adapter
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        dotsIndicator.attachTo(viewPager)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}