package com.lecture.portfolio.presentation.service

import com.lecture.portfolio.domain.entity.Introduction
import com.lecture.portfolio.domain.entity.Link
import com.lecture.portfolio.presentation.repository.PresentationRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.assertj.core.api.Assertions.*

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {

    @InjectMocks
    // 서비스에 Mock 주입 예고. lateinit으로 선언하는 이유는 Mock이 들어가기 전까지 초기화가 되지 않기 때문
    lateinit var presentationService: PresentationService

    @Mock
    // 서비스에서 레포지토리를 생성자로 주입 받기 때문에 여기서는 Mock으로 레포지토리를 생성한다.
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    // given - when - then 패턴으로 테스트
    fun testGetIntroductions() {
        // given - 조건이 주어지고
        val introductions = mutableListOf<Introduction>()
        for(i in 1..DATA_SIZE){
            val introduction = Introduction(content = "${i}", isActive = i % 2 == 0)
            introductions.add(introduction)
        }

        val activeIntroductions = introductions.filter {introduction -> introduction.isActive}

        // Mockito 라이브러리로 메서드를 호출하면 미리 만들어둔 activeIntroductions와 같은 결과를 리턴하도록 한다.
        Mockito.`when`(presentationRepository.getActiveIntroduction())
            .thenReturn(activeIntroductions)
        // when - 동작을 했을 때
        val introductionDTOs = presentationService.getIntroductions()

        // then - 결과가 어떻게 될 것인가?
        assertThat(introductionDTOs).hasSize(DATA_SIZE / 2)
        for(introductionDTO in introductionDTOs) {
            assertThat(introductionDTO.content.toInt()).isEven()
        }
    }

    @Test
    fun testGetLinks() {
        // given
        val links = mutableListOf<Link>()
        for(i in 1..DATA_SIZE) {
            val link = Link(name = "${i}_link", content = "${i}", isActive = i % 2 != 0)
            links.add(link)
        }

        val activeLinks = links.filter {link -> link.isActive}

        Mockito.`when`(presentationRepository.getActiveLink())
            .thenReturn(activeLinks)
        // when
        val linkDTOs = presentationService.getLinks()

        // then
        var expectedSize = DATA_SIZE / 2
        if (DATA_SIZE % 2 != 0) {
            expectedSize += 1
        }

        assertThat(linkDTOs).hasSize(expectedSize)
        for(linkDTO in linkDTOs) {
            assertThat(linkDTO.content.toInt()).isOdd()
        }
    }
}