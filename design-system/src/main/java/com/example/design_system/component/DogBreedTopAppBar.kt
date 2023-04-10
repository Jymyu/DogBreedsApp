package com.example.design_system.component

import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.design_system.icons.DogBreedIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogBreedsTopAppBar(
    @StringRes titleRes: Int,
    modifier: Modifier = Modifier,
    actionAlphaIcon: ImageVector,
    actionGridIcon: ImageVector,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onAlphaClick: () -> Unit = {},
    onGridClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        colors = colors,
        modifier = modifier.testTag("niaTopAppBar"),
        actions = {
            IconButton(onClick = onAlphaClick) {
                Icon(
                    imageVector = actionAlphaIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
            IconButton(onClick = onGridClick) {
                Icon(
                    imageVector = actionGridIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("Top App Bar")
@Composable
private fun NiaTopAppBarPreview() {
    DogBreedsTopAppBar(
        titleRes = android.R.string.untitled,
        actionAlphaIcon = DogBreedIcons.Person,
        actionGridIcon = DogBreedIcons.Person,
        )
}