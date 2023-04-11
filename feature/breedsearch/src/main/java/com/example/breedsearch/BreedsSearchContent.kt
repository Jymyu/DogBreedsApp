package com.example.breedsearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.model.BreedItemUiModel

@Composable
fun BreedsSearchContent(
    breeds: List<BreedItemUiModel>,
    onBreedClick: (BreedItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .padding(all = 16.dp),
        contentPadding = PaddingValues(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(items = breeds) { _: Int, item: BreedItemUiModel ->
            BreedsSearchItem(
                breedItemUiModel = item,
                onClick = { onBreedClick(item) },
            )
        }

        item {
            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
        }
    }


}
