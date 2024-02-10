package com.example.collegeevent.models

import com.example.collegeevent.R

/*class clubData:RealmObject{
    @PrimaryKey
    var name:String=""
    var logo:Painter?=null
    var work:String=""


    constructor(

    )
}*/

data class clubData(
    val name:String="",
    val imgResource : Int,
    val work:String=""
)

val clubs:List<clubData> = listOf(
    clubData(
        "Marvel",
        R.drawable.marvel,
        "Marvel is a got to go club for any electronic enthusiasts"
    ),
    clubData(
        "G2C2",
        R.drawable.g2c2,
        "Go Green club"
    ),
    clubData(
        "GDSC",
        R.drawable.gdsc,
        "Google developers student club"
    ),
    clubData(
        "IEEE",
        R.drawable.ieee,
        "Umbrella of all technical clubs"
    ),
    clubData(
        "Adhamya",
        R.drawable.ic_launcher_foreground,
        "Umbrella of all technical clubs"
    ),
    clubData(
        "Praveg",
        R.drawable.marvel,
        "Umbrella of all technical clubs"
    ),
    clubData(
        "Chethana",
        R.drawable.marvel,
        "Umbrella of all technical clubs"
    )

)