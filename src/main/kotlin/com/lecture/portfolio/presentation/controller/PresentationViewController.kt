package com.lecture.portfolio.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController {
    @GetMapping("test")
    fun test(): String {
        // resources - templates - test.html을 찾아 보여준다.
        // return "test" => test.html로 이름이 같아야한다.
        return "test"
    }
}