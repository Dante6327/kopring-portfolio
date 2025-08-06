package com.lecture.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
class Achievement(
    title: String,
    description: String,
    achievedDate: LocalDate?,
    host: String,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    var id: Long? = null

    // 어노테이션 안붙이면 알아서 title 컬럼 찾아서 들어감
    var title: String = title
    var description: String = description
    var achievedDate: LocalDate? = achievedDate
    var host: String = host
    var isActive: Boolean = isActive

}