package com.thatsussygroup.coursebuilder.controller

import org.springframework.web.bind.annotation.RestController

@RestController
@GetMapping(value = "/feedback")
class FeedbackController{
    @GetMapping("/{prof}")
    suspend fun getFeedbackByProf(@PathVariable name: String): ResponseEntity<Course?> {
        val course = feedbackRepository.findByName(name).orElse(null)
        return if (course != null) {
            ResponseEntity.ok(course)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{rating}")
    suspend fun getFeedbackByProf(@PathVariable rating: Double): ResponseEntity<Course?> {
        val course = feedbackRepository.findByRating(name).orElse(null)
        return if (course != null) {
            ResponseEntity.ok(course)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}