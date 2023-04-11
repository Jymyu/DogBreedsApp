package com.example.domain

import com.example.data.BreedsRepository
import javax.inject.Inject

class FetchBreedsUseCase @Inject constructor(private val breedsRepository: BreedsRepository) {
    operator fun invoke(page: Int) = breedsRepository.getBreeds(page)
}