package com.example.kekodfirstweekproject

import android.os.Bundle
import androidx.transition.TransitionInflater
import com.example.kekodfirstweekproject.databinding.FragmentKindnessBinding

class KindnessFragment : BaseFragment<FragmentKindnessBinding>(FragmentKindnessBinding::inflate,R.layout.fragment_kindness) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_in)
    }
}