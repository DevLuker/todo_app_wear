package com.example.todoapp.presentation.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddTask
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.items
import androidx.wear.compose.material.*
import com.example.todoapp.presentation.ui.viewmodels.TodosViewModel


@Composable
fun TodosView(navController: NavController, todosViewModel: TodosViewModel) {
    val todosList = todosViewModel.stringList
    val listState = rememberScalingLazyListState()
    Scaffold(
        timeText = {
            TimeText(
                modifier = Modifier.scrollAway(listState),
            )
        },
        vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        },
        positionIndicator = {
            PositionIndicator(scalingLazyListState = listState)
        }
    ) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            autoCentering = AutoCenteringParams(itemIndex = 0),
            state = listState
        ) {
            item {
                Chip(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    icon = {
                        Icon(imageVector = Icons.Rounded.AddTask, contentDescription = "add")
                    },
                    label = { Text(text = "Add Task") },
                    onClick = {
                        navController.navigate("add")
                    },
                    colors = ChipDefaults.chipColors(
                        contentColor = Color.White,
                        backgroundColor = Color.Blue,
                    )
                )
            }

            items(todosList) { todo ->
                AppCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    onClick = { /*TODO*/ },
                    appName = { Text(todo) },
                    time = {
                        Icon(
                            imageVector = Icons.Rounded.Delete,
                            tint = Color.Red,
                            contentDescription = "Delete",
                            modifier = Modifier.clickable {
                                todosViewModel.removeItemFromList(todo)
                            }
                        )
                    },
                    title = { },

                ) {

                }
            }
        }


    }
}