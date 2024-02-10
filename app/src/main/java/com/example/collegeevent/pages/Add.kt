package com.example.collegeevent.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.collegeevent.components.TableRow
import com.example.collegeevent.components.UnstyledTextField
import com.example.collegeevent.ui.theme.BackgroundElevated
import com.example.collegeevent.ui.theme.CollegeEventTheme
import com.example.collegeevent.ui.theme.DividerColour
import com.example.collegeevent.ui.theme.Shapes
import com.example.collegeevent.ui.theme.TopAppBarBackground
import com.example.collegeevent.ui.theme.Typography
import com.example.collegeevent.viewModels.AddScreenViewModel
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Add(navController: NavController,viewM:AddScreenViewModel= viewModel()) {

    val state by viewM.uiState.collectAsState()


    Scaffold (
        topBar = {
            MediumTopAppBar(title = { Text("Add") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = TopAppBarBackground
            ))
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier
                .clickable { }
                .padding(16.dp)
                .clip(Shapes.medium)
                .background(BackgroundElevated)
                .fillMaxWidth()
            ){
                TableRow(label = "Note", detailContent = {
                    UnstyledTextField(
                        value = state.name,
                        placeholder = { Text("Name the fest") },
                        arrangement = Arrangement.End,
                        onValueChange = viewM::setName,
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(
                            textAlign = TextAlign.Right,
                        ),
                    )
                })

                Divider(modifier=Modifier.padding(start = 16.dp), thickness = 1.dp, color = DividerColour)

                var datePickerShowing by remember {
                    mutableStateOf(false)
                }
                TableRow(label = "Date", detailContent = {
                    TextButton(onClick = { datePickerShowing = true }) {
                        Text(state.date.toString())
                    }
                    if (datePickerShowing) {
                        DatePickerDialog(onDismissRequest = { datePickerShowing = false },
                            onDateChange = { it ->
                                viewM.setDate(it)
                                datePickerShowing = false
                            },
                            initialDate = state.date,
                            title = { Text("Select date", style = Typography.titleLarge) })
                    }
                })

                Divider(modifier=Modifier.padding(start = 16.dp), thickness = 1.dp, color = DividerColour)
                Button(
                    onClick = viewM::submitDetail,
                    modifier = Modifier.padding(16.dp),
                    shape = Shapes.large,
                ) {
                    Text("Submit expense")
                }
            }
        }
    }
}

@Preview
@Composable
fun addPrev() {
    CollegeEventTheme {
        Add(navController = rememberNavController())
    }

}