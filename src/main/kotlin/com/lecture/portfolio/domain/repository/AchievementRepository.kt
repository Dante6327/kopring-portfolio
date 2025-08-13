package com.lecture.portfolio.domain.repository

import com.lecture.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long> {

    // select * from achievement where isActive = :is_active
    fun findAllByIsActive(isActive: Boolean): List<Achievement>


}