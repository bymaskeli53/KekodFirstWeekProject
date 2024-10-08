package com.example.kekodfirstweekproject


import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.CompoundButton

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.view.size
import androidx.transition.TransitionInflater

import com.example.kekodfirstweekproject.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate, R.layout.fragment_home) {

    lateinit var switchArrayList: MutableList<SwitchCaseAttributes>


    private lateinit var bottomNavigationView: BottomNavigationView




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchArrayList = mutableListOf(
            SwitchCaseAttributes(R.id.happinessFragment, binding.switchHappiness, "Happiness", icon = R.drawable.happiness),
            SwitchCaseAttributes(R.id.kindnessFragment, binding.switchKindness, "Kindness",icon = R.drawable.kindness),
            SwitchCaseAttributes(R.id.optimismFragment, binding.switchOptimism, "Optimism", icon = R.drawable.optimism),
            SwitchCaseAttributes(R.id.givingFragment, binding.switchGiving, "Giving", icon = R.drawable.giving),
            SwitchCaseAttributes(R.id.respectFragment, binding.switchRespect, "Respect", icon = R.drawable.respect),
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
                        switchCaseAttributes.title).setIcon(switchCaseAttributes.icon)




//                    bottomNavigationView.viewTreeObserver.addOnGlobalLayoutListener {
//                        val menuView = bottomNavigationView.getChildAt(0) as? ViewGroup
//                        val itemView = menuView?.getChildAt(menuView.childCount - 1)
//                        itemView?.let { view ->
//                            view.alpha = 0f
//                            view.scaleX = 0.5f
//                            view.scaleY = 0.5f
//
//                            view.animate()
//                                .alpha(1f)
//                                .scaleX(1f)
//                                .scaleY(1f)
//                                .setDuration(300)
//                                .withEndAction {
//                                    menuItem.setIcon(switchCaseAttributes.icon)
//
//                                }
//                                .start()
//
//
//
//
//
//
//
//
//
//
//
//
//                        }
//                    }

                    if (switchCaseAttributes.id == R.id.respectFragment) {
                        playRespectSound()
                    }


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
            binding.ivEgo.visibility = View.VISIBLE
            Toast.makeText(requireContext(),"I am sad for you, Click the button to break the stone and be happy",Toast.LENGTH_LONG).show()
        } else {
            enableSwitches()
            val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.stone_break)
            binding.ivEgo.startAnimation(animation)

            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}

                override fun onAnimationEnd(animation: Animation?) {
                    binding.ivEgo.visibility = View.GONE
                    Toast.makeText(requireContext(),"Congrats you break the stone now you can be happy",Toast.LENGTH_LONG).show()
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }


    }

    private fun playRespectSound() {
        val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.respect)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.release() // Ses bittiğinde MediaPlayer'ı serbest bırakın
        }
    }
}








