package com.lecture.portfolio.domain.repository

import com.lecture.portfolio.domain.entity.Achievement
import com.lecture.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository: JpaRepository<Experience, Long> {
}