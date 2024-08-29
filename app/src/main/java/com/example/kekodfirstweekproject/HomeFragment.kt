package com.example.kekodfirstweekproject


import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.view.size
import androidx.fragment.app.viewModels
import com.example.kekodfirstweekproject.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate, R.layout.fragment_home) {

    lateinit var switchArrayList : MutableList<SwitchCaseAttributes>

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var bottomNavigationView: BottomNavigationView




//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putBoolean("switchGiving", binding?.switchGiving?.isChecked ?: false)
//    }

//    override fun onViewStateRestored(savedInstanceState: Bundle?) {
//        super.onViewStateRestored(savedInstanceState)
//        savedInstanceState?.let {
//            binding?.switchGiving?.isChecked = it.getBoolean("switchGiving",false)
//        }
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        savedInstanceState?.let {
//            binding.switchGiving?.isChecked = it.getBoolean("switchGiving",false)
//        }
        switchArrayList = mutableListOf(  SwitchCaseAttributes(R.id.happinessFragment, binding.switchHappiness, "Happiness"),
                SwitchCaseAttributes(R.id.kindnessFragment, binding.switchKindness, "Kindness"),
               SwitchCaseAttributes(R.id.optimismFragment, binding.switchOptimism, "Optimism"),
                SwitchCaseAttributes(R.id.givingFragment, binding.switchGiving, "Giving"),
                SwitchCaseAttributes(R.id.respectFragment, binding.switchRespect, "Respect"),)
//        switchArrayList.addAll(
//            listOf(
//                SwitchCaseAttributes(R.id.happinessFragment, binding.switchHappiness, "Happiness"),
//                SwitchCaseAttributes(R.id.kindnessFragment, binding.switchKindness, "Kindness"),
//                SwitchCaseAttributes(R.id.optimismFragment, binding.switchOptimism, "Optimism"),
//                SwitchCaseAttributes(R.id.givingFragment, binding.switchGiving, "Giving"),
//                SwitchCaseAttributes(R.id.respectFragment, binding.switchRespect, "Respect"),
//
//
//                )
//        )
        bottomNavigationView =
           (activity as MainActivity).findViewById(R.id.bottom_nav_view)

        bottomNavigationView.isVisible = !binding.switchEgo.isChecked
        //val menu = bottomNavigationView.menu



        switchArrayList.forEach {
            it.switch.setOnCheckedChangeListener{ buttonView, isChecked ->
                onOtherSwitchesClicked(isChecked = isChecked, switchCaseAttributes = it, button = buttonView)
            }
        }


//        binding.switchKindness.setOnCheckedChangeListener { buttonView, isChecked ->
//            onOtherSwitchesClicked(isChecked = isChecked, switchCaseAttributes = switchArrayList[1], button = buttonView)// [1]
//
//        }

//        binding.switchGiving.setOnCheckedChangeListener { buttonView, isChecked ->
//            switchClick(menu, bottomNavigationView, buttonView) //[3]
//        }

//        binding.switchHappiness.setOnCheckedChangeListener { buttonView, isChecked ->
//            switchClick(menu, bottomNavigationView, buttonView) // [0]
//        }

//        binding.switchOptimism.setOnCheckedChangeListener { buttonView, isChecked ->
//            switchClick(menu, bottomNavigationView, buttonView) //[2]
//        }

//        binding.switchRespect.setOnCheckedChangeListener { buttonView, isChecked ->
//            switchClick(menu, bottomNavigationView, buttonView) // [4]
//        }

//        binding.switchEgo.setOnCheckedChangeListener { buttonView, isChecked ->
//            switchClick(menu, bottomNavigationView, buttonView)
//        }


        binding.switchEgo.setOnCheckedChangeListener { buttonView, isChecked ->
            setSwitchEgoChangeState(isChecked)

        }



    }




    fun onOtherSwitchesClicked(isChecked: Boolean, switchCaseAttributes: SwitchCaseAttributes, button: CompoundButton) {
        if (isChecked) {
            if (bottomNavigationView.menu.findItem(switchCaseAttributes.id) == null) {
                if (bottomNavigationView.menu.size <= 4) {
                    bottomNavigationView.menu.add(Menu.NONE, switchCaseAttributes.id, Menu.NONE, switchCaseAttributes.title)
                } else {
                    Toast.makeText(requireContext(), "You can only add 5 items", Toast.LENGTH_SHORT).show()
                    button.isChecked = false
                }
            }
        } else {
            bottomNavigationView.menu.removeItem(switchCaseAttributes.id)
        }
    }



//    fun switchClick(
//        menu: Menu,
//        bottomNavView: BottomNavigationView,
//        btnView: CompoundButton
//    ) {
//
//
//      //  bottomNavView.isVisible = !binding.switchEgo.isChecked
//
//        switchArrayList.forEachIndexed { index, it ->
//
//            it.switch.isEnabled = !binding.switchEgo.isChecked
//
//
//            if (binding.switchEgo.isChecked) {
//
//                it.switch.isChecked = !binding.switchEgo.isChecked
//            }
//
//            if (switchArrayList.filter { it.switch.isChecked }.size > 4) {
//                Toast.makeText(
//                    requireContext(),
//                    "You can only select 5 switches",
//                    Toast.LENGTH_SHORT
//                ).show()
//                btnView.isChecked = false
//
//
//            } else if (it.switch.isChecked && menu.findItem(it.id) == null) {
//                menu.add(Menu.NONE, it.id, Menu.NONE, it.title)
//            } else if (!it.switch.isChecked) {
//                menu.removeItem(it.id)
//            }
//
//
//        }



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




    } }








