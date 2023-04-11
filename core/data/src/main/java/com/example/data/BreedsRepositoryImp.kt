package com.example.data

import com.example.model.BreedItemUiModel
import com.example.model.network.Resource
import com.example.model.network.asUiModel
import com.example.network.dataSource.BreedsDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BreedsRepositoryImp @Inject constructor(private val breedsDataSource: BreedsDataSource) :
    BreedsRepository {

    override fun getBreeds(page: Int): Flow<Resource<List<BreedItemUiModel>>> = flow {
        emit(Resource.Loading())
        val remoteResponse = breedsDataSource.getBreeds(page)
        if (remoteResponse is Resource.Success) {
            remoteResponse.data?.map { breeds -> breeds.asUiModel() }
                ?.let { charactersList ->
                    emit(Resource.Success(charactersList))
                }
        } else
            emit(Resource.Error("There's no data"))
    }

    override fun searchBreeds(query: String): Flow<Resource<List<BreedItemUiModel>>> = flow {
        emit(Resource.Loading())
        val remoteResponse = breedsDataSource.searchBreeds(query)
        if (remoteResponse is Resource.Success) {
            remoteResponse.data?.map { breeds -> breeds.asUiModel() }
                ?.let { charactersList ->
                    emit(Resource.Success(charactersList))
                }
        } else
            emit(Resource.Error("There's no data"))
    }

}