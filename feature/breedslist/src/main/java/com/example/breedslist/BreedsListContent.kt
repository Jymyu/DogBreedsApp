package com.example.breedslist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun BreedsListContent(
    breeds: List<Int>,
    onBreedClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .testTag("interests:topics"),
        contentPadding = PaddingValues(top = 8.dp),
    ) {
        breeds.forEach { breed ->
            val topicId = breed
            item(key = topicId) {
                BreedsItem(
                    name = breed,
                    following = breed,
                    description = breed,
                    topicImageUrl = breed,
                    onClick = { onBreedClick(breed) },
                )
            }
        }

        item {
            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
        }
    }
}
