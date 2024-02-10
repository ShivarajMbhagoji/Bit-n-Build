package com.example.collegeevent.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.collegeevent.R
import com.example.collegeevent.models.clubData
import com.example.collegeevent.ui.theme.CollegeEventTheme

@Composable
fun clubCard(data:clubData) {



        Surface(
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Card(
                    modifier = Modifier.fillMaxWidth()
                        .clickable {},
                    shape = RectangleShape,
                    border = BorderStroke(2.dp, Color.Gray),

                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .height(100.dp)
                                .width(100.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Image(
                                painter = painterResource(data.imgResource),
                                contentDescription = "",
                                alignment = Alignment.CenterStart,
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 20.dp),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(text = data.name,
                                color = Color.Cyan
                            )

                            Text(text = data.work,
                                modifier = Modifier.padding(top=20.dp))
                        }
                    }
                }
            }
        }
}


@Preview
@Composable
fun cardPrev() {
    CollegeEventTheme {
        clubCard(
            data = clubData(
                "Marvel",
                R.drawable.marvel,
                "Marvel is a got to go club for any electronic enthusiasts"
            )
        )
    }

}