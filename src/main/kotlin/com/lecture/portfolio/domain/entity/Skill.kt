package com.lecture.portfolio.domain.entity

import com.lecture.portfolio.domain.constant.SkillType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Skill(
    name: String,
    type: String,
    isActive: Boolean,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null

    var name: String = name

    @Column(name = "skill_type")
    @Enumerated(EnumType.STRING)
    var type: SkillType = SkillType.valueOf(type)   // SkillType이라는 enum 중 전달 받은 type과 값이 일치하는 속성을 찾아 넣는다.
    var isActive: Boolean = isActive

}