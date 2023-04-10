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
import com.example.model.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedsListViewModel @Inject constructor(
    private val fetchBreedsUseCase: FetchBreedsUseCase
) : ViewModel() {

    private var page = 1
    private var loading = false

    private val _uiState = MutableStateFlow<BreedsListUiState>(BreedsListUiState.Loading)
    val uiState: StateFlow<BreedsListUiState> = _uiState.asStateFlow()

    private var breeds = mutableListOf<BreedItemUiModel>()

    init {
        fetchBreeds()
    }

    fun fetchBreeds() {
        if (!loading)
            viewModelScope.launch {

                fetchBreedsUseCase(page).collect { resource ->
                    when (resource) {
                        is Resource.Success -> resource.data?.let {
                            handleFetchBreedsSuccess(it)
                            loading = false
                        }
                        is Resource.Error -> {
                            BreedsListUiState.Error(resource.message.toString())
                            loading = false
                        }
                        is Resource.Loading ->{
                            _uiState.value = BreedsListUiState.Loading
                            loading = true
                        }
                    }
                }


            }
    }

    private fun handleFetchBreedsSuccess(it: List<BreedItemUiModel>) {
        breeds = (breeds + it).toMutableList()
        _uiState.value = BreedsListUiState.Breeds(breeds)
        page++
    }


}