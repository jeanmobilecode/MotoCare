package com.example.motocare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.motocare.HomeActivity
import com.example.motocare.databinding.FragmentTipsBinding
import com.example.motocare.fragments.tipsFragments.BatteryFragment
import com.example.motocare.fragments.tipsFragments.ConnectionFragment
import com.example.motocare.fragments.tipsFragments.PerformanceFragment
import com.example.motocare.fragments.tipsFragments.SecurityFragment
import com.example.motocare.utils.setCardClickListener


class FragmentTips : Fragment() {

    private var _binding : FragmentTipsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTipsBinding.inflate(inflater,container,false)
        (activity as? HomeActivity)?.setToolbarTitle("Tips")

        setCardClickListener(binding.connectionCard, ConnectionFragment())
        setCardClickListener(binding.batteryCard, BatteryFragment())
        setCardClickListener(binding.performanceCard, PerformanceFragment())
        setCardClickListener(binding.securityCard, SecurityFragment())


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}