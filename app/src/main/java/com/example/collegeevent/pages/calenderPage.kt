package com.example.collegeevent.pages

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.collegeevent.models.calenderOfEventsList
import com.example.collegeevent.ui.theme.TopAppBarBackground
import com.example.collegeevent.viewModels.calenderPageViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun calender(
    navController: NavController,
    viewM: calenderPageViewModel = viewModel()
) {

    val state by viewM.uiState.collectAsState()
    Scaffold (
        topBar = {
            MediumTopAppBar(
                title = { Text("Calender of Events", color = Color.Yellow) },
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
            calenderOfEventsList(
               state.fests,
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(
                        rememberScrollState()
                    )
            )
        }
    }
}


