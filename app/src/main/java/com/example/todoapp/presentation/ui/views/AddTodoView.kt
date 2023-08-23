package com.example.todoapp.presentation.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn

import androidx.wear.compose.material.*
import com.example.todoapp.presentation.components.TextInput
import com.example.todoapp.presentation.ui.viewmodels.TodosViewModel


@Composable
fun AddTodoView(navController: NavController, viewModel: TodosViewModel) {

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
        var title by remember { mutableStateOf("") }

        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                if (title.isNotEmpty()) {
                    Text(
                        text = "¿Deseas guardar?",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
            }

            item {
                TextInput(
                    placeholder = "Nombre de la Tarea",
                    value = title,
                    onChange = { title = it })
            }
            item {
                if (title.isNotEmpty()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {

                        Button(
                            onClick = {
                                navController.popBackStack()
                            },
                            modifier = Modifier.size(ButtonDefaults.SmallButtonSize),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.White,
                                backgroundColor = Color.Red
                            )
                        ) {
                            Icon(imageVector = Icons.Rounded.Close, contentDescription = "Back")
                        }


                        Button(
                            onClick = {
                                viewModel.addItemToList(title)
                                navController.popBackStack()
                            },
                            modifier = Modifier.size(ButtonDefaults.SmallButtonSize),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.White,
                                backgroundColor = Color.Blue,
                            )
                        ) {
                            Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add")
                        }


                    }
                }
            }

        }
    }
}

