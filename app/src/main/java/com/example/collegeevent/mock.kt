package com.example.collegeevent

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.collegeevent.models.dayEvent
import com.example.collegeevent.models.fest
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
val mockEvents= listOf<fest>(
    fest(
        "Fiesta",
        LocalDate.now().plusDays(5),
        events = listOf(
            dayEvent(
                "Quiz",
                "12:00 pm"
            ),

            dayEvent(
                "Dance",
                "2:00 pm"
            ),

            dayEvent(
                "Singing",
                "12:00 pm"
            ),
        )
    ),

    fest(
        "Impethon",
        LocalDate.now().plusDays(10),
        events = listOf(
            dayEvent(
                "MockInterview",
                "12:00 pm"
            ),

            dayEvent(
                "CP",
                "2:00 pm"
            ),

            dayEvent(
                "HackAMaze",
                "12:00 pm"
            ),
        )
    ),
    fest(
        "2nd sem exam",
        LocalDate.now().plusDays(20),
        events = listOf(
            dayEvent(
                "Maths",
                "2:00 pm"
            )
        )

    ),
    fest(
        "Hostel day",
        LocalDate.now().plusDays(50),
        listOf(
            dayEvent(
                "Dance",
                "6:00 pm"
            )
        )
    )
)

