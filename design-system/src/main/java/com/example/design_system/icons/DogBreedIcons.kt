package com.example.design_system.component

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.ui.graphics.vector.ImageVector

object DogBreedIcons {
    val ArrowDropDown = Icons.Default.ArrowDropDown
    val Person = Icons.Default.Person
    val BreedListNav = Icons.Default.Email
    val BreedListNavUnselected = Icons.Outlined.Email
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
}