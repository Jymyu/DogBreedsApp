package com.example.data

import com.example.model.BreedItemUiModel
import com.example.model.network.Resource
import kotlinx.coroutines.flow.Flow

interface BreedsRepository {
    fun getBreeds(page: Int): Flow<Resource<List<BreedItemUiModel>>>
    fun searchBreeds(query: String): Flow<Resource<List<BreedItemUiModel>>>

}