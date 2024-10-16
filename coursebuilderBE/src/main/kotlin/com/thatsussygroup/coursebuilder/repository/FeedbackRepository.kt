package com.thatsussygroup.coursebuilder.repository

import com.thatsussygroup.coursebuilder.model.Feedback
import org.springframework.data.mongodb.repository.MongoRepository

interface FeedbackRepository : MongoRepository<String, Feedback> {
    fun findByProfessor(name: String): Feedback
    fun findByRating(rating: Double): Feedback
}