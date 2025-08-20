package com.lecture.portfolio.presentation.service

import com.lecture.portfolio.presentation.dto.IntroductionDTO
import com.lecture.portfolio.presentation.dto.LinkDTO
import com.lecture.portfolio.presentation.dto.ProjectDTO
import com.lecture.portfolio.presentation.dto.ResumeDTO
import com.lecture.portfolio.presentation.repository.PresentationRepository

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService(
    private val presentationRepository: PresentationRepository
) {
    @Transactional(readOnly = true)
    fun getIntroductions(): List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroduction()
        return introductions.map {IntroductionDTO(it)}
    }

    @Transactional(readOnly = true)
    fun getLinks(): List<LinkDTO> {
        val links = presentationRepository.getActiveLink()
        return links.map {LinkDTO(it)}
    }

    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {
        val experiences = presentationRepository.getActiveExperience()
        val achievements = presentationRepository.getActiveAchievement()
        val skills = presentationRepository.getActiveSkill()
        return ResumeDTO(experiences, achievements, skills)
    }

    @Transactional(readOnly = true)
    fun getProjects(): List<ProjectDTO> {
        val projects = presentationRepository.getActiveProject()
        return projects.map {ProjectDTO(it)}
    }
}