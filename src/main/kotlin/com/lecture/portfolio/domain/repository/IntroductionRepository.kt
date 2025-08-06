package com.lecture.portfolio.domain.repository

import com.lecture.portfolio.domain.entity.Achievement
import com.lecture.portfolio.domain.entity.Experience
import com.lecture.portfolio.domain.entity.HttpInterface
import com.lecture.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository: JpaRepository<Introduction, Long> {
}