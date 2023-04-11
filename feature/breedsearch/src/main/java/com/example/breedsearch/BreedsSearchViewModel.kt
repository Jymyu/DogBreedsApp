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

package com.example.breedsearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.SearchBreedUseCase
import com.example.model.BreedItemUiModel
import com.example.model.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedsSearchViewModel @Inject constructor(
    private val fetchBreedsUseCase: SearchBreedUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<BreedsSearchUiState>(BreedsSearchUiState.BreedsSearch(
        mutableListOf()))
    val uiState: StateFlow<BreedsSearchUiState> = _uiState.asStateFlow()

    private var breeds = mutableListOf<BreedItemUiModel>()

    fun searchKeyword(searchQuery: String) {
            viewModelScope.launch {

                fetchBreedsUseCase(searchQuery).collect { resource ->
                    when (resource) {
                        is Resource.Success -> resource.data?.let {
                            handleSearchSuccess(it)
                        }
                        is Resource.Error -> {
                            BreedsSearchUiState.Error(resource.message.toString())
                        }
                        is Resource.Loading ->{
                            _uiState.value = BreedsSearchUiState.Loading
                        }
                    }
                }


            }
    }

    private fun handleSearchSuccess(it: List<BreedItemUiModel>) {
        breeds = it.toMutableList()
        _uiState.value = BreedsSearchUiState.BreedsSearch(breeds)
    }
}