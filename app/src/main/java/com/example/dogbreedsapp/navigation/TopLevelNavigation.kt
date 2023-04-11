package com.example.dogbreedsapp.navigation

import com.example.design_system.icons.DogBreedIcons
import com.example.design_system.icons.Icon
import com.example.design_system.icons.Icon.*
import com.example.breedslist.R as BreedListR
enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int,
) {
    BREEDS_LIST(
        selectedIcon = ImageVectorIcon(DogBreedIcons.Dog),
        unselectedIcon = ImageVectorIcon(DogBreedIcons.Dog),
        iconTextId = BreedListR.string.nav_button_label_breeds_list,
    ),
    BREEDS_SEARCH(
        selectedIcon = ImageVectorIcon(DogBreedIcons.Search),
        unselectedIcon = ImageVectorIcon(DogBreedIcons.Search),
        iconTextId = BreedListR.string.nav_button_label_breeds_list,
        ),
}