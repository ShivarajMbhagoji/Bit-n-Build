package com.example.collegeevent.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.dayFormat():String {
    val today= LocalDate.now()
    val tomorrow= LocalDate.now().plusDays(1)

    return when{
        this.isEqual(today) -> "Today"
        this.isEqual(tomorrow) -> "Tomorrow"
        this.year != today.year -> this.format(DateTimeFormatter.ofPattern("ddd, dd MMM yyyy"))
        else -> this.format(DateTimeFormatter.ofPattern("E, dd MMM"))
    }
}