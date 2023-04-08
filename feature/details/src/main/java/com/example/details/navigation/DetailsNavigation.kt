package com.example.details.navigation

import android.net.Uri
import android.os.Bundle
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.model.BreedItemUiModel
import com.example.model.BreedsTempRepository
import com.google.gson.Gson


internal const val breedArg = "breedArg"

fun NavController.navigateToBreedDetails( breedId: Int) {
    this.navigate("details_route/$breedId")
}

fun NavGraphBuilder.detailsBreedScreen(
    onBackClick: () -> Unit,
) {
    composable(
        route = "details_route/{$breedArg}",
        arguments = listOf(
            navArgument(breedArg) { type = NavType.IntType },
        ),
    ) {
        val breedId = it.arguments?.getInt(breedArg)
//        TopicRoute(onBackClick = onBackClick, onTopicClick = onTopicClick)
        breedId?.let { _ ->
            Text(BreedsTempRepository.data[breedId].name) }
    }
}
