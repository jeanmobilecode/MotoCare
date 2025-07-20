package com.example.motocare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.motocare.HomeActivity
import com.example.motocare.R


class FragmentGestures : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        (activity as? HomeActivity)?.setToolbarTitle("Moto Gestures")

        return inflater.inflate(R.layout.fragment_gestures, container, false)
    }


}