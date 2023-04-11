package com.example.design_system.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Grid3x3
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material.icons.filled.ViewDay
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector

object DogBreedIcons {
    val Person = Icons.Default.Person
    val ArrowBack = Icons.Rounded.ArrowBack
    val OrderBy = Icons.Filled.Sort
    val Grid = Icons.Filled.Grid3x3
    val Dog = Icons.Filled.ViewDay
    val Search = Icons.Filled.Search

}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
}