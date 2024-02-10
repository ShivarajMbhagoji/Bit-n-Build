package com.example.collegeevent.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.collegeevent.R
import com.example.collegeevent.mockEvents
import com.example.collegeevent.models.fest
import com.example.collegeevent.ui.theme.Typography
import com.example.collegeevent.utils.dayFormat

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun festBox(
    fests: List<fest>
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        fests.forEach(){fest->
            Image(
                painter = painterResource(id = R.drawable.fiest_mock),
                contentDescription = "",
                modifier = Modifier.clickable { }
            )
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = fest.name,
                    style = Typography.titleMedium
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = "fest.date)",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun eventcardPrev() {
    festBox(fests = mockEvents)
}