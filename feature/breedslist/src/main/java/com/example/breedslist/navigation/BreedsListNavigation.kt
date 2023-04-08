package com.example.breedslist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.breedslist.BreedsListRoute
import com.example.model.BreedItemUiModel

const val breedsListGraphRoutePattern = "breeds_list_graph"
const val breedsListRoute = "breeds_list_route"

fun NavController.navigateToBreedsGraph(navOptions: NavOptions? = null) {
    this.navigate(breedsListGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.breedsListGraph(
    onBreedClick: (Int) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = breedsListGraphRoutePattern,
        startDestination = breedsListRoute,
    ) {
        composable(route = breedsListRoute) {
            BreedsListRoute(onBreedClick)
        }
        nestedGraphs()
    }
}