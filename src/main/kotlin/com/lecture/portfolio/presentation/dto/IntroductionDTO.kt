package com.lecture.portfolio.presentation.dto

import com.lecture.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String,
) {
    constructor(introduction: Introduction) : this(
        content = introduction.content,
    )
}