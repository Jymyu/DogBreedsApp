package com.example.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BreedItemUiModel(
    val breedGroup: String?,
    val id: Int?,
    val imageUrl: String?,
    val name: String?,
    val origin: String?,
    val temperament: String?,
    val category: String?,
) : Parcelable
