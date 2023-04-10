package com.example.details

import com.example.model.BreedItemUiModel

sealed interface DetailsUiState {
    object Loading : DetailsUiState

    data class Success(
        val breed: BreedItemUiModel,
    ) : DetailsUiState

    object Empty : DetailsUiState
}
