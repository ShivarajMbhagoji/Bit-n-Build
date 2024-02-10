package com.example.collegeevent.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collegeevent.mockEvents
import com.example.collegeevent.models.fest
import com.example.collegeevent.ui.theme.Typography
import com.example.collegeevent.utils.dayFormat
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun calenderOfEventsCard(
    fest:fest,
){
    Surface(
        modifier = Modifier

            .fillMaxWidth(),
        shape = RectangleShape
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = fest.name,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color= Color.Blue
            )

            Text(
                text = "",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                style = Typography.labelMedium,
                color = Color.DarkGray
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun cardPreview() {
    calenderOfEventsCard(mockEvents[0])
}

