package com.thatsussygroup.coursebuilder.model

import org.bson.types.ObjectId

class Course(
    val id: ObjectId,
    val courseName: String,
    val courseDescription: String,
    val typeOfCourse: String,
    val credits: Int
)