package com.thatsussygroup.coursebuilder.repository

import com.thatsussygroup.coursebuilder.model.Section
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SectionRepository : MongoRepository<String, Section> {
    fun findByCourse(name: String): List<Section>
    fun findBySection(name: String, sectionNumber: String): Section
    fun findBySeats(seats: Int): Section
    // More functions may be added here as needed
}