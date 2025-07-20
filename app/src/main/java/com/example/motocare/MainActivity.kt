package com.example.motocare

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.example.motocare.databinding.ActivityMainBinding
import com.example.motocare.pages.Pages
import com.example.motocare.pages.PagesAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var fabButton: FloatingActionButton
    private lateinit var dotsIndicator: DotsIndicator
    private lateinit var pagesList: List<Pages>
    private var LASTITEM = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        setupViewPager()
        setupFabBehavior()

    }

    private fun setupViews() {
        viewPager = binding.viewPager2
        fabButton = binding.floatingActionButton
        dotsIndicator = binding.dotsIndicator

        pagesList = mutableListOf(
            Pages(getString(R.string.take_care_of_your_phone), getString(R.string.essential_tips), R.drawable.img_motorola_cell),

            Pages(getString(R.string.security_first), getString(R.string.protect_your_data), R.drawable.img_motorola_cell_2),

            Pages(getString(R.string.moto_gestures), getString(R.string.learn_how_to_use_motorola), R.drawable.img_motorola_cell_3),

            Pages(getString(R.string.battery_saving_tips), getString(R.string.optimize_energy), R.drawable.img_motorola_cell_4),

            Pages(getString(R.string.usefull_settings), getString(R.string.discover_system_features), R.drawable.img_motorola_cell_5)
            )
    }

    private fun setupViewPager() {
        val adapter = PagesAdapter(pagesList)
        viewPager.adapter = adapter
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        dotsIndicator.attachTo(viewPager)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateFabIcon(position)
            }
        })
    }

    private fun updateFabIcon(position: Int) {
        val iconRes = if (position == LASTITEM) {R.drawable.ic_check } else { R.drawable.outline_arrow_forward_24 }
        fabButton.setImageResource(iconRes)
    }

    private fun setupFabBehavior() {
        fabButton.setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem < LASTITEM) {
                viewPager.setCurrentItem(currentItem + 1, true)
            } else {
                navigateToHome()
            }
        }
    }

    private fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
