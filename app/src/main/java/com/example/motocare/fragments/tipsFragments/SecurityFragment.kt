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
import com.example.motocare.databinding.FragmentConnectionBinding
import com.example.motocare.databinding.FragmentSecurityBinding


class SecurityFragment : Fragment() {

    private var _binding : FragmentSecurityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSecurityBinding.inflate(inflater,container,false)
        (activity as? HomeActivity)?.setToolbarTitle("Security Tips")

        val securityTips = listOf(
            Tip("Set a Screen Lock", "Use PIN, pattern, or fingerprint for safer access to your device."),
            Tip("Smart Lock", "Keep your phone unlocked in trusted places like home or your pocket."),
            Tip("App Permissions Check", "Review which apps can access your camera, mic, and location."),
            Tip("Find My Device", "Enable location and Find My Device to track your phone if lost."),
            Tip("Safe Browsing Mode", "Use Chrome's Safe Browsing to avoid harmful websites and downloads.")
        )

        val rv = binding.securityRv
        rv.adapter = TipsAdapter(securityTips)
        rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}