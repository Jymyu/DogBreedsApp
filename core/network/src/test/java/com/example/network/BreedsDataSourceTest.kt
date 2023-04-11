package com.example.network

import com.example.network.api.NetworkApi
import com.example.network.dataSource.BreedsDataSourceImpl
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BreedsDataSourceTest {

    private lateinit var dataSource: BreedsDataSourceImpl

    private val networkApi = mockk<NetworkApi>(relaxed = true)

    @Before
    fun setup() {
        dataSource = BreedsDataSourceImpl((networkApi))
    }

    @Test
    fun `datasource getDogBreedsByPage should call apiInterface fetchDogBreedsByPage`() = runBlocking {

        dataSource.getBreeds(5)
        coVerify { networkApi.fetchDogBreedsByPage(BreedsDataSourceImpl.pageLimit, 5) }
    }

    @Test
    fun `datasource getDogBreedsBySearchQuery should call networkApi fetchDogBreedsBySearchQuery`() = runBlocking {
        dataSource.searchBreeds("dog")
        coVerify { networkApi.searchBreeds("dog") }
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }
}