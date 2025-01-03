package bekhamdev.gamefinder.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import bekhamdev.gamefinder.presentation.screens.detail.DetailScreen
import bekhamdev.gamefinder.presentation.screens.home.HomeScreen
import bekhamdev.gamefinder.presentation.screens.home.HomeViewModel

@Composable
fun NavManager() {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeScreen(
                navigateToDetail = { id ->
                    navController.navigate(Detail(id = id))
                },
                homeViewModel = homeViewModel
            )
        }

        composable<Detail> {
            val detail: Detail = it.toRoute()
            DetailScreen(
                id = detail.id,
                comeBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}