package com.thatsussygroup.coursebuilder.controller

import org.springframework.web.bind.annotation.RestController

@RestController
@GetMapping(value = "/course")
class CourseController{

    @GetMapping("/{id}")
    suspend fun getCourseById(@PathVariable id: String): ResponseEntity<Course?> {
        val course = courseRepository.findByName(id).orElse(null)
        return if (course != null) {
            ResponseEntity.ok(course)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{type}")
suspend fun getCourseByType(@PathVariable type: String): ResponseEntity<Course?> {
    val course = courseRepository.findByTypeOfCourse(type).orElse(null)
    return if (course != null) {
        ResponseEntity.ok(course)
    } else {
        ResponseEntity.notFound().build()
    }

    @GetMapping("/{credits}")
suspend fun getCourseByCredits(@PathVariable credits: Int): ResponseEntity<Course?> {
    val course = courseRepository.findByCredits(credits).orElse(null)
    return if (course != null) {
        ResponseEntity.ok(course)
    } else {
        ResponseEntity.notFound().build()
    }
}

@GetMapping
    fun getAllCourses(): ResponseEntity<List<Course>> = runBlocking {
        val courses = courseRepository.findAll()
        ResponseEntity.ok(courses)
    }

}
}

