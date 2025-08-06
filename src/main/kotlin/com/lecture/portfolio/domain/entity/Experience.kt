package com.lecture.portfolio.domain.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany

@Entity
class Experience(
    title: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?,
    endMonth: Int?,
    isActive: Boolean,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null

    var title: String = title

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive: Boolean = isActive

    // OneToMany : 일대다 표현식
    // targetEntity : 자식 클래스 대상 지정
    // fetch : 연관된 자식 쿼리를 할지 말지. ORDINARY -> 연관된 자식 전부 쿼리 / LAZY -> 연관되지 않으면 쿼리 X
    // cascade : 부모에 변경사항이 생기면 자식에도 이 변경사항을 적용할지
    @OneToMany(targetEntity = ExperienceDetail::class, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "experience_id")
    var details: MutableList<ExperienceDetail> = mutableListOf()

    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }

        return "${endYear}.${endMonth}"
    }

    fun update(
        title: String,
        description: String,
        startYear: Int,
        startMonth: Int,
        endYear: Int?,
        endMonth: Int?,
        isActive: Boolean,
    ) {
        this.title = title
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(details: MutableList<ExperienceDetail>?) {
        if (details != null) {
            this.details.addAll(details)
        }
    }
}