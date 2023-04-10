/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.breedslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.FetchBreedsUseCase
import com.example.model.BreedItemUiModel
import com.example.model.BreedsTempRepository
import com.example.model.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class BreedsListViewModel @Inject constructor(
    private val fetchBreedsUseCase: FetchBreedsUseCase
) : ViewModel() {

    val uiState: StateFlow<BreedsListUiState> =
        fetchBreedsUseCase(0)
            .map{ resource ->
                when (resource) {
                    is Resource.Loading -> BreedsListUiState.Loading
                    is Resource.Success -> BreedsListUiState.Breeds(resource.data)
                    is Resource.Error -> BreedsListUiState.Error(resource.message.toString())
                }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = BreedsListUiState.Loading,
        )
}

 fun getMockedBreeds(): Flow<List<BreedItemUiModel>> = flow {
     delay(1000)
    emit(
        BreedsTempRepository.data
    )
}