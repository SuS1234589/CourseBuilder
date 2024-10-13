package com.thatsussygroup.coursebuilder.model

import org.bson.types.ObjectId

class Section(
    val id: ObjectId,
    val number: Int,
    val courseID: String,
    val prof: String,
    val startTime: String,
    val endTime: String,
    val seats: Int,
    val location: String,
    val days: Array<Boolean>
)