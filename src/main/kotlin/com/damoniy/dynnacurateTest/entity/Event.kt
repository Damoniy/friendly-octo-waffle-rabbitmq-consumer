package com.damoniy.dynnacurateTest.entity

import com.damoniy.dynnacurateTest.persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "events")
data class Event(
    @Id val id: Int?,
    val eventType: String,
    val eventDateTime: String
): PersistentObject