package com.example.breedslist

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.design_system.component.BreedsLoadingWheel
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
    )
}

@Composable
internal fun BreedsListScreen(
    uiState: BreedsListUiState,
    onBreedClick: (BreedItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
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