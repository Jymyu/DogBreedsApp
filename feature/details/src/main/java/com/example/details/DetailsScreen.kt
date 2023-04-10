package com.example.details

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.design_system.component.DynamicAsyncImage
import com.example.design_system.icons.DogBreedIcons
import com.example.model.BreedItemUiModel

@Composable
internal fun DetailsRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    breed: BreedItemUiModel,
) {
    DetailsScreen(
        breedItemUiModel = breed,
        modifier = modifier,
        onBackClick = onBackClick,
    )
}

@VisibleForTesting
@Composable
internal fun DetailsScreen(
    breedItemUiModel: BreedItemUiModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
        }

        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
            ) {
                IconButton(onClick = { onBackClick() }) {
                    Icon(
                        imageVector = DogBreedIcons.ArrowBack,
                        contentDescription = stringResource(R.string.back_label),
                    )
                }
            }
        }
        item {
            Column(
                modifier = Modifier.padding(horizontal = 24.dp),
            ) {
                DynamicAsyncImage(
                    imageUrl = breedItemUiModel.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(216.dp)
                        .padding(bottom = 12.dp),
                )
                Text(breedItemUiModel.name, style = MaterialTheme.typography.displayMedium)
                if (breedItemUiModel.category.isNotEmpty()) {
                    Text(
                        stringResource(R.string.category, breedItemUiModel.category),
                        modifier = Modifier.padding(top = 24.dp),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
                if (breedItemUiModel.origin.isNotEmpty()) {
                    Text(
                        stringResource(R.string.origin,breedItemUiModel.origin),
                        modifier = Modifier.padding(top = 24.dp),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
                if (breedItemUiModel.temperament.isNotEmpty()) {
                    Text(
                        stringResource(R.string.temperament,breedItemUiModel.temperament),
                        modifier = Modifier.padding(top = 24.dp),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }

            }
        }
        item {
            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
        }
    }
}