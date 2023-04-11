package com.example.dogbreedsapp.navigation

import com.example.design_system.icons.DogBreedIcons
import com.example.design_system.icons.Icon
import com.example.design_system.icons.Icon.*
import com.example.dogbreedsapp.R
import com.example.breedslist.R as BreedListR
enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    BREEDS_LIST(
        selectedIcon = ImageVectorIcon(DogBreedIcons.Dog),
        unselectedIcon = ImageVectorIcon(DogBreedIcons.Dog),
        iconTextId = BreedListR.string.nav_button_label_breeds_list,
        titleTextId = R.string.app_name,
    ),
//    BOOKMARKS(
//        selectedIcon = DrawableResourceIcon(NiaIcons.Bookmarks),
//        unselectedIcon = DrawableResourceIcon(NiaIcons.BookmarksBorder),
//        iconTextId = bookmarksR.string.saved,
//        titleTextId = bookmarksR.string.saved,
//    ),
//    INTERESTS(
//        selectedIcon = ImageVectorIcon(NiaIcons.Grid3x3),
//        unselectedIcon = ImageVectorIcon(NiaIcons.Grid3x3),
//        iconTextId = interestsR.string.interests,
//        titleTextId = interestsR.string.interests,
//    ),
}