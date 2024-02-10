package com.example.collegeevent.pages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
import com.example.collegeevent.components.eventCard
import com.example.collegeevent.mockEvents
import com.example.collegeevent.models.fest
import com.example.collegeevent.ui.theme.CollegeEventTheme
import com.example.collegeevent.ui.theme.TopAppBarBackground

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Events(
    navController:NavController,
    fests:List<fest>,
) {
    Scaffold (
        topBar = {
            MediumTopAppBar(
                title = { Text("Upcoming Fests") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground,
                    titleContentColor = Color.Black
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
            modifier = Modifier.padding(innerPadding)
        ){
           fests.forEach {fest->
                eventCard(fest = fest)

           }
        }
    }
}

@Preview
@Composable
fun eventPagePrev() {
    CollegeEventTheme {
        Events(navController = rememberNavController(), fests = mockEvents)
    }
}