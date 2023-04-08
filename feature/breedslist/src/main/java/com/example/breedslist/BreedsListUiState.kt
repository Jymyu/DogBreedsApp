package com.example.breedslist

sealed interface BreedsListUiState {
    object Loading : BreedsListUiState

    data class Breeds(
        val Breeds: List<Int>,
    ) : BreedsListUiState

    object Empty : BreedsListUiState
}
