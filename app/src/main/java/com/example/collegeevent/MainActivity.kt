package com.example.collegeevent

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.collegeevent.pages.Add
import com.example.collegeevent.pages.Events
import com.example.collegeevent.pages.calender
import com.example.collegeevent.pages.clubs
import com.example.collegeevent.ui.theme.CollegeEventTheme
import com.example.collegeevent.ui.theme.TopAppBarBackground

class MainActivity : ComponentActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CollegeEventTheme(){
                val navController = rememberNavController()
                val backStackEntry
                by navController.currentBackStackEntryAsState()

                Scaffold(
                    bottomBar = {
                        NavigationBar(containerColor = TopAppBarBackground) {
                            NavigationBarItem(
                                selected = backStackEntry?.destination?.route == "calender",
                                onClick = { navController.navigate("calender") },
                                label = {
                                    Text("Calender")
                                },
                                icon = {
                                    Icon(
                                        painterResource(R.drawable.add),
                                        contentDescription = "Upload"
                                    )
                                }
                            )

                            NavigationBarItem(
                                selected = backStackEntry?.destination?.route == "events",
                                onClick = { navController.navigate("events") },
                                label = {
                                    Text("Events")
                                },
                                icon = {
                                    Icon(
                                        painterResource(R.drawable.add),
                                        contentDescription = "Upload"
                                    )
                                }
                            )

                            NavigationBarItem(
                                selected = backStackEntry?.destination?.route == "add",
                                onClick = { navController.navigate("add") },
                                label = {
                                    Text("Add")
                                },
                                icon = {
                                    Icon(
                                        painterResource(R.drawable.add),
                                        contentDescription = "Upload"
                                    )
                                }
                            )

                            NavigationBarItem(
                                selected = backStackEntry?.destination?.route == "grouping",
                                onClick = { navController.navigate("grouping") },
                                label = {
                                    Text("Grouping")
                                },
                                icon = {
                                    Icon(
                                        painterResource(R.drawable.add),
                                        contentDescription = "Upload"
                                    )
                                }
                            )

                            NavigationBarItem(
                                selected = backStackEntry?.destination?.route == "clubs",
                                onClick = { navController.navigate("clubs") },
                                label = {
                                    Text("Clubs")
                                },
                                icon = {
                                    Icon(
                                        painterResource(R.drawable.add),
                                        contentDescription = "Upload"
                                    )
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = "calender") {
                        composable("calender") {
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                            ) {
                                calender(navController = navController)
                            }
                        }

                        composable("events") {
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                            ) {
                                Events(navController = navController, fests = mockEvents)
                            }
                        }

                        composable("add") {
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                            ) {
                                Add(navController = navController)
                            }
                        }

                        composable("grouping") {
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                            ) {
                                Greeting(name = "grouping")
                            }
                        }

                        composable("clubs") {
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                            ) {
                                clubs(navController = navController, clubs = com.example.collegeevent.models.clubs)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CollegeEventTheme {

    }
}