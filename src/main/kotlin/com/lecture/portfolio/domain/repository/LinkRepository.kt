package com.lecture.portfolio.domain.repository

import com.lecture.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Link>

}