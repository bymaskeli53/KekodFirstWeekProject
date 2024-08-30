package com.example.kekodfirstweekproject

import android.os.Bundle
import android.view.View
import androidx.transition.TransitionInflater
import com.example.kekodfirstweekproject.databinding.FragmentKindnessBinding

class KindnessFragment : BaseFragment<FragmentKindnessBinding>(FragmentKindnessBinding::inflate,R.layout.fragment_kindness) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_in)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvKindness.text =
            getString(R.string.the_quality_of_being_friendly_generous_and_considerate)
    }
}