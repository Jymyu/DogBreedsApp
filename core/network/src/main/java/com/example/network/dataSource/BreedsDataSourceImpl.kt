package com.example.network.dataSource

import com.example.model.network.BreedNetworkModel
import com.example.model.network.Resource
import com.example.network.api.NetworkApi
import com.example.network.api.requestData
import javax.inject.Inject

class BreedsDataSourceImpl @Inject constructor(
    private val networkApi: NetworkApi
) : BreedsDataSource {
    override suspend fun getBreeds(page: Int): Resource<List<BreedNetworkModel>> = requestData {
        networkApi.fetchDogBreedsByPage(pageLimit,page)
    }

    override suspend fun searchBreeds(query: String): Resource<List<BreedNetworkModel>> = requestData {
       networkApi.searchBreeds(query)
    }

    companion object {
        const val pageLimit = 20
    }
}