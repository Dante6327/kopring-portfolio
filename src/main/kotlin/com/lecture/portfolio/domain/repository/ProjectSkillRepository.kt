package com.lecture.portfolio.domain.repository

import com.lecture.portfolio.domain.entity.Achievement
import com.lecture.portfolio.domain.entity.Experience
import com.lecture.portfolio.domain.entity.HttpInterface
import com.lecture.portfolio.domain.entity.Introduction
import com.lecture.portfolio.domain.entity.Link
import com.lecture.portfolio.domain.entity.Project
import com.lecture.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository: JpaRepository<ProjectSkill, Long> {
}