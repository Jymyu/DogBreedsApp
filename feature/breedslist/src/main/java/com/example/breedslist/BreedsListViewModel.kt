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
import com.example.model.BreedItemUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedsListViewModel @Inject constructor(
) : ViewModel() {

    val uiState: StateFlow<BreedsListUiState> =
        getMockedBreeds().map(
            BreedsListUiState::Breeds,
        ).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = BreedsListUiState.Loading,
        )
}

 fun getMockedBreeds(): Flow<List<BreedItemUiModel>> = flow {
     delay(1000)
    emit(
        listOf(
            BreedItemUiModel("group",0,"https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg","Dog","Origin","temperament","category"),
            BreedItemUiModel("group",1,"https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg","Dog","Origin","temperament","category"),
            BreedItemUiModel("group",2,"https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg","Dog","Origin","temperament","category"),
            BreedItemUiModel("group",3,"https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg","Dog","Origin","temperament","category"),
            BreedItemUiModel("group",4,"https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg","Dog","Origin","temperament","category"),
            BreedItemUiModel("group",5,"https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg","Dog","Origin","temperament","category"),
            BreedItemUiModel("group",6,"https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg","Dog","Origin","temperament","category"),

            )
    )
}