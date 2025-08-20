package com.lecture.portfolio.presentation.repository

import com.lecture.portfolio.domain.entity.Achievement
import com.lecture.portfolio.domain.entity.Experience
import com.lecture.portfolio.domain.entity.Introduction
import com.lecture.portfolio.domain.entity.Link
import com.lecture.portfolio.domain.entity.Project
import com.lecture.portfolio.domain.entity.Skill
import com.lecture.portfolio.domain.repository.AchievementRepository
import com.lecture.portfolio.domain.repository.ExperienceRepository
import com.lecture.portfolio.domain.repository.IntroductionRepository
import com.lecture.portfolio.domain.repository.LinkRepository
import com.lecture.portfolio.domain.repository.ProjectRepository
import com.lecture.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val experienceRepository: ExperienceRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository
) {
    fun getActiveAchievement(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }
    fun getActiveExperience(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }
    fun getActiveIntroduction(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }
    fun getActiveLink(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }
    fun getActiveSkill(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }
    fun getActiveProject(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }
}