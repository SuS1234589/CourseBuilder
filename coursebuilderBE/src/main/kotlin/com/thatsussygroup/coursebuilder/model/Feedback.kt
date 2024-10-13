package com.thatsussygroup.coursebuilder.model

import org.bson.types.ObjectId

class Feedback(
    val id: ObjectId,
    val professorName: String,
    val review: String,
    val rating: Double
)