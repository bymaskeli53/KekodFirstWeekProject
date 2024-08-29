package com.example.kekodfirstweekproject

import android.widget.Switch
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.materialswitch.MaterialSwitch

data class SwitchCaseAttributes(
    val id: Int,
    val switch: MaterialSwitch,
    val title: String,
    val icon: Int,
)
