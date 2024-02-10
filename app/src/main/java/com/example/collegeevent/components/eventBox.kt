package com.example.collegeevent.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.collegeevent.mockEvents
import com.example.collegeevent.models.fest
import com.example.collegeevent.ui.theme.BackgroundElevated
import com.example.collegeevent.ui.theme.CollegeEventTheme
import com.example.collegeevent.ui.theme.Typography
import com.example.collegeevent.utils.dayFormat

@Composable
fun eventCard(
    fest:fest
) {
    Card(
        modifier = Modifier.padding(16.dp),
        shape = RectangleShape,
        border = BorderStroke(2.dp,Color.Gray)
    ) {
        Column (
            modifier = Modifier.fillMaxWidth()
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = fest.name, style = Typography.titleLarge)
                Text(text = fest.date.dayFormat())
            }
            Divider(modifier=Modifier.padding(start = 16.dp), thickness = 1.dp, color = Color.Gray)
            
            fest.events.forEach{event->
                Surface(
                    shape = RectangleShape,
                    color = BackgroundElevated,
                    modifier = Modifier.fillMaxWidth()
                ) {
                   Row(
                       horizontalArrangement = Arrangement.SpaceBetween
                   ) { 
                       Text(text = event.event)
                       Text(text = event.time)
                   }
                }
                Divider(modifier=Modifier.padding(start = 16.dp), thickness = 1.dp, color = Color.Gray)
            }
        }
    }
}

@Preview
@Composable
fun eventCardprev() {
    CollegeEventTheme {
        eventCard(fest = mockEvents[0])
    }
}
