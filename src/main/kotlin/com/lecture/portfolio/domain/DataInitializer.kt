package com.lecture.portfolio.domain

import com.lecture.portfolio.domain.constant.SkillType
import com.lecture.portfolio.domain.entity.Achievement
import com.lecture.portfolio.domain.entity.Experience
import com.lecture.portfolio.domain.entity.ExperienceDetail
import com.lecture.portfolio.domain.entity.Introduction
import com.lecture.portfolio.domain.entity.Link
import com.lecture.portfolio.domain.entity.Project
import com.lecture.portfolio.domain.entity.ProjectDetail
import com.lecture.portfolio.domain.entity.ProjectSkill
import com.lecture.portfolio.domain.entity.Skill
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

        val links = mutableListOf<Link>(
            Link(
                name = "Link1",
                content = "Introduction1",
                isActive = true,
            ),
            Link(
                name = "Link2",
                content = "Introduction2",
                isActive = false,
            ),
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "Experience1",
            description = "111",
            startYear = 2025,
            startMonth = 1,
            endYear = 2025,
            endMonth = 2,
            isActive = true,
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "ep1detail1", isActive = true),
                ExperienceDetail(content = "ep1detail2", isActive = true),
            )
        )
        val experience2 = Experience(
            title = "Experience2",
            description = "111",
            startYear = 2025,
            startMonth = 1,
            endYear = 2025,
            endMonth = 2,
            isActive = true,
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "ep2detail1", isActive = true),
                ExperienceDetail(content = "ep2detail2", isActive = true),
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val django = Skill(name = "Django", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "Mysql", type = SkillType.DATABASE.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
        val kafka = Skill(name = "Kafka", type = SkillType.TOOL.name, isActive = true)
        SkillRepository.saveAll(mutableListOf(java, kotlin, python, spring, django, mysql, redis, kafka))

        val project1 = Project(
            name = "Project1",
            description = "111",
            startYear = 2025,
            startMonth = 1,
            endYear = 2025,
            endMonth = 2,
            isActive = true,
        )

        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "projectDetila1", url = null, isActive = true),
                ProjectDetail(content = "projectDetila2", url = null, isActive = true),
                ProjectDetail(content = "projectDetila3", url = null, isActive = true),
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(
                    project = project1,
                    skill = java
                ),
                ProjectSkill(
                    project = project1,
                    skill = spring
                ),
                ProjectSkill(
                    project = project1,
                    skill = mysql
                ),
                ProjectSkill(
                    project = project1,
                    skill = redis
                )
            )
        )


        val project2 = Project(
            name = "Project2",
            description = "222",
            startYear = 2025,
            startMonth = 1,
            endYear = 2025,
            endMonth = 2,
            isActive = true,
        )

        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "projectDetila4", url = null, isActive = true),
                ProjectDetail(content = "projectDetila5", url = null, isActive = true),
                ProjectDetail(content = "projectDetila6", url = null, isActive = true),
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(
                    project = project2,
                    skill = django
                ),
                ProjectSkill(
                    project = project2,
                    skill = python
                ),
                ProjectSkill(
                    project = project2,
                    skill = kafka
                ),
                ProjectSkill(
                    project = project2,
                    skill = kotlin
                )
            )
        )

        projectRepository.saveAll(mutableListOf(project1, project2))
    }
}