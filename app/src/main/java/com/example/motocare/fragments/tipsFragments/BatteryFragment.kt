package com.example.motocare.fragments.tipsFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.motocare.HomeActivity
import com.example.motocare.R
import com.example.motocare.data.Tip
import com.example.motocare.databinding.FragmentBatteryBinding
import com.example.motocare.databinding.FragmentConnectionBinding

class BatteryFragment : Fragment() {

    private var _binding : FragmentBatteryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentBatteryBinding.inflate(inflater,container,false)
        (activity as? HomeActivity)?.setToolbarTitle("Battery Tips")

        val batteryTips = listOf(
            Tip("Battery Saver Mode", "Turn on Battery Saver to extend power when you're running low."),
            Tip("Adaptive Battery", "Let your phone learn which apps you use most and limit background activity."),
            Tip("Dark Theme = Power Saving", "Enable Dark Mode to reduce screen power usage, especially on OLED displays."),
            Tip("Screen Timeout", "Set your screen to turn off quickly when not in use to save energy."),
            Tip("Stop Battery-Draining Apps", "Check for apps using too much battery in Settings and limit them.")
        )

        val rv = binding.batteryRv
        rv.adapter = TipsAdapter(batteryTips)
        rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}