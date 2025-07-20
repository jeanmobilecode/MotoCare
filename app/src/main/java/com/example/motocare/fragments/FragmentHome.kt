package com.example.motocare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.motocare.HomeActivity
import com.example.motocare.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        setCardClickListener(binding.firstCard, FragmentTips())
        setCardClickListener(binding.secondCard, FragmentGestures())
        setCardClickListener(binding.thirdCard, FragmentInfo())

        (activity as? HomeActivity)?.setToolbarTitle("Home")

        return binding.root
    }

    private fun setCardClickListener(cardView: View, fragment: Fragment) {
        cardView.setOnClickListener {
            (activity as? HomeActivity)?.replaceFragment(fragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}