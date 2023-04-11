package com.example.dogbreedsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.breedsearch.navigation.breedsSearchGraph
import com.example.breedslist.navigation.breedsListGraph
import com.example.breedslist.navigation.breedsListGraphRoutePattern
import com.example.breedslist.navigation.navigateToBreedsGraph
import com.example.details.navigation.detailsBreedScreen
import com.example.details.navigation.navigateToBreedDetails

@Composable
fun DogBreedsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = breedsListGraphRoutePattern,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {

        breedsListGraph(
            onBreedClick = {
                           navController.navigateToBreedDetails(it)
            },
            nestedGraphs = {
                detailsBreedScreen(
                    onBackClick = navController::popBackStack,
                )
            },
        )
        breedsSearchGraph(
            onBreedClick = {
                navController.navigateToBreedDetails(it)
            },
            nestedGraphs = {
                detailsBreedScreen(
                    onBackClick = navController::popBackStack,
                )
            },
        )
    }
}