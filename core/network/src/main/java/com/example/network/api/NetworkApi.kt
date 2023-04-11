package com.example.network.api

import com.example.model.network.BreedNetworkModel
import com.example.network.api.NetworkConstants.BREEDS_ENDPOINT_URL
import com.example.network.api.NetworkConstants.SEARCH_BREEDS_ENDPOINT_URL
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {

    @GET(BREEDS_ENDPOINT_URL)
    suspend fun fetchDogBreedsByPage(
        @Query("limit") pageLimit: Int,
        @Query("page") pageNumber: Int
    ): List<BreedNetworkModel>

    @GET(SEARCH_BREEDS_ENDPOINT_URL)
    suspend fun searchBreeds(
        @Query("q") query: String
    ): List<BreedNetworkModel>

}