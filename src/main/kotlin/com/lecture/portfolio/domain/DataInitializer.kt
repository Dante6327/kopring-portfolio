package com.lecture.portfolio.domain

import com.lecture.portfolio.domain.entity.Achievement
import com.lecture.portfolio.domain.entity.Introduction
import com.lecture.portfolio.domain.repository.AchievementRepository
import com.lecture.portfolio.domain.repository.ExperienceRepository
import com.lecture.portfolio.domain.repository.IntroductionRepository
import com.lecture.portfolio.domain.repository.LinkRepository
import com.lecture.portfolio.domain.repository.ProjectRepository
import com.lecture.portfolio.domain.repository.SkillRepository
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

// Component : Spring에서는 @Component 어노테이션이 붙은 곳을 찾아 인스턴스를 생성하고 관리한다.
@Component
// Profile : profile이 default일 때만 클래스 인스턴스를 생성. 개발 환경에서 데이터를 임의로 만들어 쓸 때 사용
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val SkillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {
    @PostConstruct
    fun initializeData() {
        println("Initializing Data...")

        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "study hard!",
                description = "111",
                host = "host1",
                achievedDate = LocalDate.of(2025,8,7),
                isActive = true,
            ),
            Achievement(
                title = "study normal!",
                description = "222",
                host = "host2",
                achievedDate = LocalDate.of(2025,8,6),
                isActive = true,
            ),
        )

        achievementRepository.saveAll(achievements)
        val introductions = mutableListOf<Introduction>(
            Introduction(
                content = "Introduction1",
                isActive = true,
            ),
            Introduction(
                content = "Introduction2",
                isActive = false,
            ),
        )
        introductionRepository.saveAll(introductions)
    }
}