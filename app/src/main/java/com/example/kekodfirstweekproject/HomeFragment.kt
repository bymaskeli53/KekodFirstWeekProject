package com.example.kekodfirstweekproject


import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.kekodfirstweekproject.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate, R.layout.fragment_home) {

    private val switchArrayList = ArrayList<SwitchCaseAttributes>()


    override fun FragmentHomeBinding.bindingView() {
        switchArrayList.addAll(
            listOf(
                SwitchCaseAttributes(R.id.happinessFragment, switchHappiness, "Happiness"),
                SwitchCaseAttributes(R.id.kindnessFragment, switchKindness, "Kindness"),
                SwitchCaseAttributes(R.id.optimismFragment, switchOptimism, "Optimism"),
                SwitchCaseAttributes(R.id.givingFragment, switchGiving, "Giving"),
                SwitchCaseAttributes(R.id.respectFragment, switchRespect, "Respect"),



                )
        )
        val bottomNavigationView =
            (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        bottomNavigationView.isVisible = !switchEgo.isChecked
        val menu = bottomNavigationView.menu





        switchKindness.setOnCheckedChangeListener { buttonView, isChecked ->
            switchClick(menu,bottomNavigationView,buttonView)

        }

        switchGiving.setOnCheckedChangeListener { buttonView, isChecked ->
            switchClick(menu,bottomNavigationView,buttonView)
        }

        switchHappiness.setOnCheckedChangeListener { buttonView, isChecked ->
            switchClick(menu,bottomNavigationView,buttonView)
        }

        switchOptimism.setOnCheckedChangeListener { buttonView, isChecked ->
            switchClick(menu,bottomNavigationView,buttonView)
        }

        switchRespect.setOnCheckedChangeListener { buttonView, isChecked ->
            switchClick(menu,bottomNavigationView,buttonView)
        }

        switchEgo.setOnCheckedChangeListener { buttonView, isChecked ->
            switchClick(menu,bottomNavigationView,buttonView)
        }
    }

    fun FragmentHomeBinding.switchClick(menu: Menu,bottomNavView: BottomNavigationView,btnView: CompoundButton) {


        bottomNavView.isVisible = !switchEgo.isChecked

        switchArrayList.forEachIndexed { index,it ->

            it.switch.isEnabled = !switchEgo.isChecked


            if (switchEgo.isChecked) {

                it.switch.isChecked = !switchEgo.isChecked
            }

            if (switchArrayList.filter { it.switch.isChecked }.size  > 4) {
                Toast.makeText(requireContext(),"You can only select 5 switches",Toast.LENGTH_SHORT).show()
                btnView.isChecked = false


            }
           else if (it.switch.isChecked && menu.findItem(it.id) == null ) {
                menu.add(index, it.id, Menu.NONE, it.title)
            } else if (!it.switch.isChecked) {
             menu.removeItem(it.id)
            }


        }

    }


}






