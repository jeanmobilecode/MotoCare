package com.example.motocare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.example.motocare.databinding.ActivityMainBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var titleList = mutableListOf<String>()
    private var descriptionList = mutableListOf<String>()
    private var imagelist = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postToList()
        val viewPager = binding.viewPager2

        viewPager.adapter = ViewPagerAdapter(titleList,descriptionList,imagelist)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val dotsIndicator = binding.dotsIndicator
        dotsIndicator.attachTo(viewPager)

    }

    private fun addToList(title: String, description: String, image: Int){
        titleList.add(title)
        descriptionList.add(description)
        imagelist.add(image)
    }

    private fun postToList() {
        for(i in 1..5){
            addToList("Differemt Support for different people $i", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley $i", R.drawable.img_motorola_cell)
        }
    }

}