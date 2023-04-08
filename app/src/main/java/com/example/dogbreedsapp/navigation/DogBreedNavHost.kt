package com.example.dogbreedsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.breedslist.navigation.breedsListGraph
import com.example.breedslist.navigation.breedsListGraphRoutePattern
import com.example.breedslist.navigation.breedsListRoute

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
            },
            nestedGraphs = {
//                topicScreen(
//                    onBackClick = navController::popBackStack,
//                    onTopicClick = {},
//                )
            },
        )
    }
}