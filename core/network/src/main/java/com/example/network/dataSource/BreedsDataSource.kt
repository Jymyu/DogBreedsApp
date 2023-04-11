package com.example.network.dataSource

import com.example.model.network.BreedNetworkModel
import com.example.model.network.Resource

interface BreedsDataSource {
    suspend fun getBreeds(page: Int): Resource<List<BreedNetworkModel>>
    suspend fun searchBreeds(query: String): Resource<List<BreedNetworkModel>>
}