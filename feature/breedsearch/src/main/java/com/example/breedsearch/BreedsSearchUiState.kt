package com.example.breedsearch

import com.example.model.BreedItemUiModel

sealed interface BreedsSearchUiState {
    object Loading : BreedsSearchUiState

    data class BreedsSearch(
        val Breeds: List<BreedItemUiModel>?,
    ) : BreedsSearchUiState


    data class Error(val errorMessage: String) : BreedsSearchUiState
}
