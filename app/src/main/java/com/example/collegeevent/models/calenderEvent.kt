package com.example.collegeevent.models

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Ignore
import io.realm.kotlin.types.annotations.PrimaryKey
import java.time.LocalDateTime

class fest():RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.create()

     var name: String = ""

     private var _dateValue: String = LocalDateTime.now().toString()
     val date: LocalDateTime get() { return LocalDateTime.parse(_dateValue) }
    @Ignore
     var events: List<dayEvent> = listOf()

    constructor(
        name:String,
        date:LocalDateTime,
        events:List<dayEvent>
    ) : this() {
        this.name=name
        this._dateValue = date.toString()
        this.events=events
    }
 }

class dayEvent():RealmObject {
    @PrimaryKey
    var event: String = ""
    var time: String = ""

    constructor(
        event:String,
        time:String
    ) : this() {
        this.event=event
        this.time=time
    }
}