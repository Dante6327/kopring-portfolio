package com.lecture.portfolio.domain

import com.lecture.portfolio.domain.repository.AchievementRepository
import com.lecture.portfolio.domain.repository.ExperienceRepository
import com.lecture.portfolio.domain.repository.IntroductionRepository
import com.lecture.portfolio.domain.repository.LinkRepository
import com.lecture.portfolio.domain.repository.ProjectRepository
import com.lecture.portfolio.domain.repository.SkillRepository
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

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
    }
}