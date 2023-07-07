package com.cumulation.retrofitexample.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cumulation.retrofitexample.screen.Pages
import com.cumulation.retrofitexample.viewmodel.RetrofitViewModel

@Composable
fun SetUpNavigation(
    navController: NavHostController,
    viewModel: RetrofitViewModel = hiltViewModel()
) {
    NavHost(navController = navController, startDestination = Screen.page.route) {

        composable(Screen.page.route) {
            Pages(viewModel = viewModel)
        }
    }
}

sealed class Screen(val route: String) {
    object page : Screen(route = "page")
}