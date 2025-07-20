package com.example.motocare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.motocare.HomeActivity
import com.example.motocare.databinding.FragmentTipsBinding


class FragmentTips : Fragment() {

    private var _binding : FragmentTipsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTipsBinding.inflate(inflater,container,false)
        (activity as? HomeActivity)?.setToolbarTitle("Tips")



        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}