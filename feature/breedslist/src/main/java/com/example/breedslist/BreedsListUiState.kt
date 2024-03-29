package com.example.breedslist

import com.example.model.BreedItemUiModel

sealed interface BreedsListUiState {
    object Loading : BreedsListUiState

    data class Breeds(
        val Breeds: List<BreedItemUiModel>?,
        val isGrid: Boolean,
        val isLoadingMore: Boolean,
    ) : BreedsListUiState

    data class Error(val errorMessage: String) : BreedsListUiState
}
