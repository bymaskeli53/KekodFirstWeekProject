package com.example.kekodfirstweekproject


import android.os.Bundle
import android.view.View
import com.example.kekodfirstweekproject.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate, R.layout.fragment_home)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottom_nav_view).visibility = View.GONE

        binding.switchEgo.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.apply {
                    switchHappiness.isEnabled = false
                    switchKindness.isEnabled = false
                    switchOptimism.isEnabled = false
                    switchGiving.isEnabled = false
                    switchRespect.isEnabled = false

                    switchHappiness.isChecked = false
                    switchKindness.isChecked = false
                    switchOptimism.isChecked = false
                    switchGiving.isChecked = false
                    switchRespect.isChecked = false


                    (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottom_nav_view).visibility = View.GONE

                }
            } else {
                binding.apply {
                    switchHappiness.isEnabled = true
                    switchKindness.isEnabled = true
                    switchOptimism.isEnabled = true
                    switchGiving.isEnabled = true
                    switchRespect.isEnabled = true

                    (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottom_nav_view).visibility = View.VISIBLE

            }
        }

    }
} }






