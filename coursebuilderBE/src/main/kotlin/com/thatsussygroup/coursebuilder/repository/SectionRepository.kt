package com.thatsussygroup.coursebuilder.repository

import com.thatsussygroup.coursebuilder.model.Section
import org.springframework.data.mongodb.repository.MongoRepository

interface SectionRepository : MongoRepository<String, Section> {
    fun findByCourse(courseID: String): List<Section>
    fun findByProf(prof: String): List<Section>
    fun findBySeats(seats: Int): Section
    
    // More functions may be added here as needed
}