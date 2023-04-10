package com.example.breedslist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.design_system.icons.DogBreedIcons
import com.example.design_system.component.DynamicAsyncImage

@Composable
fun BreedsItem(
    name: String?,
    imageUrl: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    itemSeparation: Dp = 16.dp,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)
                .clickable { onClick() }
                .padding(vertical = itemSeparation),
        ) {
            imageUrl?.let { BreedImage(it, iconModifier.size(256.dp)) }
            Spacer(modifier = Modifier.width(16.dp))
            name?.let { Text(it, style = MaterialTheme.typography.titleMedium) }
        }
    }
}

@Composable
private fun BreedImage(imageUrl: String, modifier: Modifier = Modifier) {
    if (imageUrl.isEmpty()){
        Icon(
            modifier = modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(4.dp),
            imageVector = DogBreedIcons.Person,
            contentDescription = null, // decorative image
        )

    } else {
        DynamicAsyncImage(
            imageUrl = imageUrl,
            contentDescription = null,
            modifier = modifier,
        )

    }


}