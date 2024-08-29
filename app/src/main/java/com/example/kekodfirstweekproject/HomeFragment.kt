package com.example.kekodfirstweekproject


import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.CompoundButton

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.view.size

import com.example.kekodfirstweekproject.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate, R.layout.fragment_home) {

    lateinit var switchArrayList: MutableList<SwitchCaseAttributes>


    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchArrayList = mutableListOf(
            SwitchCaseAttributes(R.id.happinessFragment, binding.switchHappiness, "Happiness"),
            SwitchCaseAttributes(R.id.kindnessFragment, binding.switchKindness, "Kindness"),
            SwitchCaseAttributes(R.id.optimismFragment, binding.switchOptimism, "Optimism"),
            SwitchCaseAttributes(R.id.givingFragment, binding.switchGiving, "Giving"),
            SwitchCaseAttributes(R.id.respectFragment, binding.switchRespect, "Respect"),
        )

        bottomNavigationView =
            (activity as MainActivity).findViewById(R.id.bottom_nav_view)

        bottomNavigationView.isVisible = !binding.switchEgo.isChecked




        switchArrayList.forEach {
            it.switch.setOnCheckedChangeListener { buttonView, isChecked ->
                onOtherSwitchesClicked(
                    isChecked = isChecked,
                    switchCaseAttributes = it,
                    button = buttonView
                )
            }
        }

        binding.switchEgo.setOnCheckedChangeListener { buttonView, isChecked ->
            setSwitchEgoChangeState(isChecked)

        }


    }


    fun onOtherSwitchesClicked(
        isChecked: Boolean,
        switchCaseAttributes: SwitchCaseAttributes,
        button: CompoundButton
    ) {
        if (isChecked) {
            if (bottomNavigationView.menu.findItem(switchCaseAttributes.id) == null) {
                if (bottomNavigationView.menu.size <= 4) {
                    bottomNavigationView.menu.add(
                        Menu.NONE,
                        switchCaseAttributes.id,
                        Menu.NONE,
                        switchCaseAttributes.title
                    )
                } else {
                    Toast.makeText(requireContext(), "You can only add 5 items", Toast.LENGTH_SHORT)
                        .show()
                    button.isChecked = false
                }
            }
        } else {
            bottomNavigationView.menu.removeItem(switchCaseAttributes.id)
        }
    }


    private fun enableSwitches() {
        switchArrayList.forEach {
            it.switch.isEnabled = true

        }
    }

    private fun disableSwitches() {
        switchArrayList.forEach {
            it.switch.isEnabled = false
            it.switch.isChecked = false
        }
    }

    private fun setSwitchEgoChangeState(isChecked: Boolean) {

        bottomNavigationView.isVisible = !binding.switchEgo.isChecked
        if (isChecked) {

            disableSwitches()
        } else {

            enableSwitches()
        }


    }
}








