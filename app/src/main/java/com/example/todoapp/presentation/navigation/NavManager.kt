package com.example.todoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.todoapp.presentation.ui.viewmodels.TodosViewModel
import com.example.todoapp.presentation.ui.views.AddTodoView
import com.example.todoapp.presentation.ui.views.TodosView

@Composable
fun NavManager( viewModel: TodosViewModel){

    val navController = rememberSwipeDismissableNavController()

    SwipeDismissableNavHost(navController = navController, startDestination = "home"){
        composable("home"){
            TodosView(navController, viewModel)
        }

        composable("add"){
            AddTodoView(navController, viewModel)
        }
    }
}