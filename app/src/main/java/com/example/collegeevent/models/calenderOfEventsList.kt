package com.example.collegeevent.models

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.collegeevent.components.calenderOfEventsCard

@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun calenderOfEventsList(
    festList:List<fest>,
    modifier: Modifier
){
    Column(modifier = modifier.padding(4.dp)) {
        festList.forEach { fest ->
            calenderOfEventsCard(fest)
        }
    }
}