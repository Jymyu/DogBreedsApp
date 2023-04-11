package com.example.breedsearch.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.breedsearch.BreedsSearchRoute
import com.example.model.BreedItemUiModel


const val breedsSearchGraphRoutePattern = "breeds_search_graph"
const val breedsSearchRoute = "breeds_search_route"

fun NavController.navigateToBreedsSearchGraph(navOptions: NavOptions? = null) {
    this.navigate(breedsSearchGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.breedsSearchGraph(
    onBreedClick: (BreedItemUiModel) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = breedsSearchGraphRoutePattern,
        startDestination = breedsSearchRoute,
    ) {
        composable(route = breedsSearchRoute) {
            BreedsSearchRoute(onBreedClick)
        }
        nestedGraphs()
    }
}