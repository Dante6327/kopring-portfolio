package com.lecture.portfolio.presentation.controller

import com.lecture.portfolio.domain.constant.SkillType
import com.lecture.portfolio.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController(
    private val presentationService: PresentationService
) {
    @GetMapping("test")
    fun test(): String {
        // resources - templates - test.html을 찾아 보여준다.
        // return "test" => test.html로 이름이 같아야한다.
        return "test"
    }

    @GetMapping("/")
    fun index(model: Model) : String {
        val introductions = presentationService.getIntroductions()
        val links = presentationService.getLinks()

        model.addAttribute("introductions", introductions)
        model.addAttribute("links", links)
        return "presentation/index"
    }

    @GetMapping("/resume")
    fun resume(model: Model) : String {
        val resume = presentationService.getResume()

        model.addAttribute("resume", resume)
        model.addAttribute("skillTypes", SkillType.values())

        return "presentation/resume"
    }

    @GetMapping("/projects")
    fun projects(model: Model) : String {
        val projects = presentationService.getProjects()

        model.addAttribute("projects", projects)

        return "presentation/projects"
    }
}