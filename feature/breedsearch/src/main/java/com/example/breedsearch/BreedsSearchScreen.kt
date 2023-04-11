package com.example.breedsearch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.design_system.component.BreedsLoadingWheel
import com.example.design_system.component.DogBreedsSearchTopAppBar
import com.example.design_system.component.DogBreedsTopAppBar
import com.example.design_system.icons.DogBreedIcons
import com.example.model.BreedItemUiModel

@Composable
internal fun BreedsSearchRoute(
    onBreedClick: (BreedItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BreedsSearchViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BreedsSearchScreen(
        uiState = uiState,
        onBreedClick = onBreedClick,
        modifier = modifier,
        viewModel
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BreedsSearchScreen(
    uiState: BreedsSearchUiState,
    onBreedClick: (BreedItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BreedsSearchViewModel,

    ) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        DogBreedsSearchTopAppBar(
            titleRes = R.string.app_bar_title,
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent,
            )
        )

        var text by rememberSaveable { mutableStateOf("") }

        Row {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text(stringResource(R.string.search_text_field_label)) },
            )

            IconButton(onClick = { viewModel.searchKeyword(text) }) {
                Icon(
                    imageVector = DogBreedIcons.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        }

        when (uiState) {

            is BreedsSearchUiState.BreedsSearch ->  uiState.Breeds?.let {
                BreedsSearchContent(
                    breeds = it,
                    onBreedClick = onBreedClick,
                    modifier = modifier,
                )
            }
            is BreedsSearchUiState.Error -> BreedsSearchEmptyScreen()
            BreedsSearchUiState.Loading ->  BreedsLoadingWheel(
                modifier = modifier,
                contentDesc = stringResource(id = R.string.loading),
            )
        }
    }
}

@Composable
private fun BreedsSearchEmptyScreen() {
    Text(text = stringResource(id = R.string.empty_screen))
}