package com.thatsussygroup.coursebuilder.repository

import com.thatsussygroup.coursebuilder.model.Course
import org.springframework.data.mongodb.repository.MongoRepository

interface CourseRepository : MongoRepository<String, Course> {
    fun findByName(courseName: String): Course
    fun findByTypeOfCourse(typeOfCourse: String): List<Course>
    fun findByCredits(credits: Int): List<Course>
    fun findAll(): List<Course>
}