package com.example.details.navigation

import android.net.Uri
import android.os.Bundle
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.details.DetailsRoute
import com.example.model.BreedItemUiModel
import com.example.model.BreedsTempRepository
import com.google.gson.Gson


internal const val breedArg = "breedArg"

fun NavController.navigateToBreedDetails(breedItemUiModel: BreedItemUiModel) {
    val json = Uri.encode(Gson().toJson(breedItemUiModel))
    this.navigate("details_route/$json")
}

fun NavGraphBuilder.detailsBreedScreen(
    onBackClick: () -> Unit,
) {
    composable(
        route = "details_route/{$breedArg}",
        arguments = listOf(
            navArgument(breedArg) { type = NavType.StringType },
        ),
    ) {
        val breed = it.arguments?.getString(breedArg)
        val parsed = Gson().fromJson(breed, BreedItemUiModel::class.java)
        breed?.let { _ ->
            DetailsRoute(onBackClick = onBackClick, breed = parsed)
        }
    }
}



