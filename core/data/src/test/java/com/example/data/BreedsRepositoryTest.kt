package com.example.data

import com.example.model.network.BreedNetworkModel
import com.example.model.network.Resource
import com.example.network.dataSource.BreedsDataSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BreedsRepositoryTest {

    private lateinit var dogBreedRepository: BreedsRepositoryImp

    private val breedsDataSource = mockk<BreedsDataSource>(relaxed = true)

    @Before
    fun setup() {
        dogBreedRepository = BreedsRepositoryImp(breedsDataSource)
    }

    @Test
    fun `when repository getBreeds returns error`() = runBlocking {
        coEvery { breedsDataSource.getBreeds(mockk()) } returns Resource.Error("Error")

        dogBreedRepository.getBreeds(1).collect {}

        coVerify { breedsDataSource.getBreeds(1) }
    }

    @Test
    fun `when repository getBreeds returns success `() = runBlocking {
        val list = listOf<BreedNetworkModel>()
        val response = Resource.Success(list)
        coEvery { breedsDataSource.getBreeds(1) } returns response

        assertEquals(response.data, dogBreedRepository.getBreeds(1).drop(1).first().data)
        coVerify { breedsDataSource.getBreeds(1) }


    }

    @Test
    fun `when repository searchBreeds returns success `() = runBlocking {
        val list = listOf<BreedNetworkModel>()
        val response = Resource.Success(list)
        coEvery { breedsDataSource.searchBreeds("search") } returns response

        assertEquals(response.data, dogBreedRepository.searchBreeds("search").drop(1).first().data)
        coVerify { breedsDataSource.searchBreeds("search") }

    }

    @Test
    fun `when repository searchBreeds returns error`() = runBlocking {
        coEvery { breedsDataSource.searchBreeds("search") } returns Resource.Error("Error")

        dogBreedRepository.searchBreeds("search").collect {}

        coVerify { breedsDataSource.searchBreeds("search") }
    }
}