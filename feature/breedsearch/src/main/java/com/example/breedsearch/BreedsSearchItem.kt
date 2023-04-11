package com.example.breedsearch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.model.BreedItemUiModel

@Composable
fun BreedsSearchItem(
    breedItemUiModel: BreedItemUiModel?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.padding(top = 16. dp)
            .clickable { onClick() }
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4. dp),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
                .padding(vertical = 8.dp),

        ) {
            breedItemUiModel?.name?.let {
                Text(
                    it,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            breedItemUiModel?.breedGroup?.let {
                Text(
                    stringResource(R.string.breed_group, it),
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            breedItemUiModel?.origin?.let {
                Text(
                    stringResource(R.string.origin, it),
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

        }
    }
}