package com.example.dogbreedsapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.breedsearch.navigation.breedsSearchRoute
import com.example.breedsearch.navigation.navigateToBreedsSearchGraph
import com.example.breedslist.navigation.breedsListRoute
import com.example.breedslist.navigation.navigateToBreedsGraph
import com.example.dogbreedsapp.navigation.TopLevelDestination


@Composable
fun rememberNiaAppState(
    navController: NavHostController = rememberNavController(),
): NiaAppState {
    return remember(navController) {
        NiaAppState(navController)
    }
}

class NiaAppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            breedsListRoute -> TopLevelDestination.BREEDS_LIST
            breedsSearchRoute -> TopLevelDestination.BREEDS_SEARCH
            else -> null
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.BREEDS_LIST -> navController.navigateToBreedsGraph(topLevelNavOptions)
            TopLevelDestination.BREEDS_SEARCH -> navController.navigateToBreedsSearchGraph(topLevelNavOptions)
        }

    }
}