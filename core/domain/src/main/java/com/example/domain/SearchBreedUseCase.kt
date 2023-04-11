package com.example.domain

import com.example.data.BreedsRepository
import javax.inject.Inject

class SearchBreedUseCase @Inject constructor(private val breedsRepository: BreedsRepository) {
    operator fun invoke(query: String) = breedsRepository.searchBreeds(query)
}