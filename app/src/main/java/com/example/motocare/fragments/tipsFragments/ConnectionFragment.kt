package com.example.motocare.fragments.tipsFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.motocare.HomeActivity
import com.example.motocare.data.Tip
import com.example.motocare.databinding.FragmentConnectionBinding

class ConnectionFragment : Fragment() {

    private var _binding : FragmentConnectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentConnectionBinding.inflate(inflater,container,false)
        (activity as? HomeActivity)?.setToolbarTitle("Connection Tips")

        val connectionTips = listOf(
            Tip("Wi-Fi Assistant", "Auto-connect to trusted Wi-Fi networks and save data on the go."),
            Tip("Bluetooth Auto-On", "Enable Bluetooth automation for faster pairing with known devices."),
            Tip("Airplane Mode Trick", "Toggle Airplane Mode for a few seconds to quickly reset weak connections."),
            Tip("Mobile Hotspot Sharing", "Turn your phone into a hotspot to share your internet safely with others."),
            Tip("NFC Tap & Go", "Use NFC for quick file transfers or contactless payments.")
        )

        val rv = binding.connectionRv
        rv.adapter = TipsAdapter(connectionTips)
        rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}