package com.example.motocare.fragments

import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.motocare.HomeActivity
import com.example.motocare.R
import com.example.motocare.databinding.FragmentInfoBinding


class FragmentInfo : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var tvDeviceInfo: TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as? HomeActivity)?.setToolbarTitle("Device Info")
        _binding = FragmentInfoBinding.inflate(inflater, container, false)


        tvDeviceInfo = binding.tvDeviceInfo
        tvDeviceInfo.text = getDeviceInfo()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun getDeviceInfo(): String {
        val manufacturer = Build.MANUFACTURER.capitalize()
        val model = Build.MODEL
        val deviceName = if (model.startsWith(manufacturer, ignoreCase = true)) model.capitalize() else "$manufacturer $model"
        val osVersion = Build.VERSION.RELEASE
        val sdkInt = Build.VERSION.SDK_INT

        val metrics = resources.displayMetrics
        val width = metrics.widthPixels
        val height = metrics.heightPixels
        val densityDpi = metrics.densityDpi

        val androidId = Settings.Secure.getString(requireContext().contentResolver, Settings.Secure.ANDROID_ID)

        return """
            Device: $deviceName
            
            OS Version: $osVersion (SDK $sdkInt)
            
            Screen: ${width}x${height} px, $densityDpi dpi
            
            Android ID: $androidId
            
        """.trimIndent()
    }

}