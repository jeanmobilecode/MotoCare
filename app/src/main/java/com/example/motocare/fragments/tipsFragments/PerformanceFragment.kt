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
import com.example.motocare.databinding.FragmentPerformanceBinding

class PerformanceFragment : Fragment() {

    private var _binding : FragmentPerformanceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPerformanceBinding.inflate(inflater,container,false)
        (activity as? HomeActivity)?.setToolbarTitle("Performance Tips")

        val performanceTips = listOf(
            Tip("Free Up Space", "Use the Files app to clean junk and free storage with one tap."),
            Tip("Disable Unused Apps", "Turn off apps you rarely use to speed up your phone."),
            Tip("Auto Restart Weekly", "Schedule weekly reboots to keep the system fresh and responsive."),
            Tip("Use Lite Apps", "Install “Lite” versions of apps like Facebook or Messenger to save RAM."),
            Tip("Update Regularly", "Keep your phone updated to get the latest performance improvements.")
        )

        val rv = binding.performanceRv
        rv.adapter = TipsAdapter(performanceTips)
        rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}