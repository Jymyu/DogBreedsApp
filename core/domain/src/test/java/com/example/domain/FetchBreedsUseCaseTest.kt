package com.example.domain

import com.example.data.BreedsRepository
import io.mockk.clearAllMocks
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Test
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FetchBreedsUseCaseTest {

    private lateinit var fetchBreedsByPageUseCase: FetchBreedsUseCase

    private val dogBreedRepository = mockk<BreedsRepository>(relaxed = true)

    @Before
    fun setup() {
        fetchBreedsByPageUseCase = FetchBreedsUseCase(dogBreedRepository)
    }

    @Test
    fun `invoke should call repository and get data by page`() {

        fetchBreedsByPageUseCase.invoke(5)
        verify { dogBreedRepository.getBreeds(5) }
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }
}