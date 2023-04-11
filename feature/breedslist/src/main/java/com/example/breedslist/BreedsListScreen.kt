package com.example.breedslist

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.design_system.component.BreedsLoadingWheel
import com.example.design_system.component.DogBreedsTopAppBar
import com.example.design_system.icons.DogBreedIcons
import com.example.model.BreedItemUiModel

@Composable
internal fun BreedsListRoute(
    onBreedClick: (BreedItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BreedsListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BreedsListScreen(
        uiState = uiState,
        onBreedClick = onBreedClick,
        modifier = modifier,
        viewModel
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BreedsListScreen(
    uiState: BreedsListUiState,
    onBreedClick: (BreedItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BreedsListViewModel,

    ) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        DogBreedsTopAppBar(
            titleRes = R.string.nav_button_label_breeds_list,
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent,
            ),
            actionAlphaIcon = DogBreedIcons.OrderBy,
            actionGridIcon = DogBreedIcons.Grid,
            onAlphaClick = {viewModel.onAlphaClick()},
            onGridClick = {viewModel.onGridClick()})


        when (uiState) {
            BreedsListUiState.Loading ->
                BreedsLoadingWheel(
                    modifier = modifier,
                    contentDesc = stringResource(id = R.string.loading),
                )
            is BreedsListUiState.Breeds ->
                uiState.Breeds?.let {
                    BreedsListContent(
                        breeds = it,
                        onBreedClick = onBreedClick,
                        modifier = modifier,
                        fetchMoreData = {viewModel.fetchBreeds()},
                        uiState.isGrid,
                    )
                }
            is BreedsListUiState.Error -> BreedsEmptyScreen()
        }
    }
}

@Composable
private fun BreedsEmptyScreen() {
    Text(text = stringResource(id = R.string.empty_screen))
}