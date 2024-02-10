package com.example.collegeevent.models

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

val config = RealmConfiguration.create(schema = setOf(fest::class, dayEvent::class))
val db: Realm = Realm.open(config)