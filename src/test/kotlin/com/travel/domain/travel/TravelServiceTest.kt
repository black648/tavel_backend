package com.travel.domain.travel.service

import com.travel.domain.travel.domain.Travel
import com.travel.domain.travel.domain.TravelRepository
import com.travel.domain.travel.dto.*
import org.assertj.core.api.Assertions
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TravelServiceTest @Autowired constructor(
        private var travelService: TravelService,
        private var travelRepository: TravelRepository,
) {
    @AfterEach
    fun clean() {
        travelRepository.deleteAll()
    }

    @DisplayName("[단위테스트] 여행 등록")
    @Test
    fun save() {
        //given
        travelService.save(TravelSaveDto(
                name = "대구여행 렛츠 고",
                userId = "gogogo",
                travelStartDate = "20221229",
                travelEndDate = "20230101"
        ))

        //when
        val list: List<Travel> = travelRepository!!.findAll()

        //then
        assertThat(list[0].name).isEqualTo("대구여행 렛츠 고")
    }

    @DisplayName("[단위테스트] 여행 수정")
    @Test
    @Throws(Exception::class)
    fun update() {
        //given
        travelService.save(TravelSaveDto(
                name = "대구여행 렛츠 고",
                userId = "gogogo",
                travelStartDate = "20221229",
                travelEndDate = "20230101"
        ))

        var saveKey: Long = travelRepository.findAll()[0].id!!

        //when
        travelService.update(saveKey, TravelUpdateDto(
                name = "대구여행 렛츠 고",
                travelStartDate = "20221229",
                travelEndDate = "20230101"))

        //then
        val travel: List<Travel> = travelRepository.findAll()
        assertThat(travel[0].name).isEqualTo("전주여행 렛츠 고")
        assertThat(travel[0].travelStartDate).isEqualTo("20221230")
        assertThat(travel[0].travelEndDate).isEqualTo("20230101")
    }

    @DisplayName("[단위테스트] 여행 삭제 ")
    @Test
    fun delete() {
        //given
        travelService.save(TravelSaveDto(
                name = "대구여행 렛츠 고",
                userId = "gogogo",
                travelStartDate = "20221229",
                travelEndDate = "20230101"
        ))

        //when
        travelService.delete(travelRepository.findAll()[0].id!!)

        //then
        val travelList: List<Travel> = travelRepository.findAll()
        Assertions.assertThat(travelList.size).isEqualTo(0)
    }

//    @DisplayName("[단위테스트] 여행 삭제 ")
//    @Test
//    fun get() {
//        val responseDto: TravelResponseDto = travelService.get(TravelRequestDto(
//                id = 10L,
//                searchType = TravelSearchType.PLAN))
//        assertThat(responseDto.id).isEqualTo(10L)
//    }
}