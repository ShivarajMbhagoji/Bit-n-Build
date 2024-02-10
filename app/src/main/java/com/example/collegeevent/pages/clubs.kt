package com.example.collegeevent.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.collegeevent.components.clubCard
import com.example.collegeevent.models.clubData
import com.example.collegeevent.ui.theme.CollegeEventTheme
import com.example.collegeevent.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun clubs(
    navController: NavController,
    clubs:List<clubData>
) {
    Scaffold (
        topBar = {
            MediumTopAppBar(
                title = { Text("Explore college clubs") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground,
                    titleContentColor = Color.Blue
                ),
                navigationIcon = {
                    Surface(
                        onClick = { navController.popBackStack() },
                        color = Color.Transparent
                    ) {
                        Row {
                            Icon(Icons.Filled.CheckCircle, contentDescription = "")
                        }
                    }
                }
            )
        }
    ){innerPadding->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            clubs.forEach(){club->
                clubCard(data = club)
            }
        }
    }
}

@Preview
@Composable
fun previ() {
    CollegeEventTheme {
        clubs(navController = rememberNavController(), clubs = com.example.collegeevent.models.clubs)
    }
}