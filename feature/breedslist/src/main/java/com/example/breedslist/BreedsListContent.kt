package com.example.breedslist

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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.model.BreedItemUiModel

@Composable
fun BreedsListContent(
    breeds: List<BreedItemUiModel>,
    onBreedClick: (BreedItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
    fetchMoreData: () -> Unit
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 8.dp),
    ) {
        itemsIndexed(items = breeds){index: Int, item: BreedItemUiModel ->
            if (index+1 > breeds.size-4)
                fetchMoreData()
            BreedsItem(
                name = item.name,
                imageUrl = item.imageUrl,
                onClick = { onBreedClick(item) },
            )
        }

        item {
            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
        }
    }
}
