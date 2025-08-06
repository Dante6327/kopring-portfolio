package com.lecture.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @CreatedDate
    @Column(nullable = false, updatable = false)    // null 불가능, update 불가능
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(nullable = false, updatable = true)
    var modifiedDateTime: LocalDateTime = LocalDateTime.now()
}