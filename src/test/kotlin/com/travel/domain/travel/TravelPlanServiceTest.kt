package com.travel.domain.travel

import com.travel.domain.travel.domain.plan.TravelPlanRepository
import com.travel.domain.travel.dto.plan.TravelPlanSaveDto
import com.travel.domain.travel.service.TravelPlanService
import com.travel.domain.travel.service.TravelService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TravelPlanServiceTest @Autowired constructor(
    private var travelService: TravelService,
    private var travelPlanService: TravelPlanService,
    private var travelPlanRepository: TravelPlanRepository
) {
    @DisplayName("[단위테스트] 여행계획 등록")
    @Test
    fun save() {
        //given
        travelPlanService.save(TravelPlanSaveDto(
                travelId = 1L,
                travelDate = "20221229",
                place = "동성로"
        ))

        //when
        val list = travelPlanRepository!!.findAll()

        //then
        Assertions.assertThat(list[0].place).isEqualTo("동성로")
    }

    @DisplayName("[단위테스트] 여행계획 일괄 등록(Update 기능)")
    @Test
    fun saveAll() {
        val planSaveDtoList: MutableList<TravelPlanSaveDto> = ArrayList()
        planSaveDtoList.add(TravelPlanSaveDto(travelId = 1, travelDate = "20230101", place = "대학로2", orderNo = 1))
        planSaveDtoList.add(TravelPlanSaveDto(travelId = 1, travelDate = "20230101", place = "대학로", orderNo = 2))
        planSaveDtoList.add(TravelPlanSaveDto(travelId = 1, travelDate = "20230101", place = "계명대", orderNo = 3))
        planSaveDtoList.add(TravelPlanSaveDto(travelId = 1, travelDate = "20230101", place = "서문시장", orderNo = 4))
        planSaveDtoList.add(TravelPlanSaveDto(travelId = 1, travelDate = "20230101", place = "경북대", orderNo = 5))

        //given
        travelPlanService!!.saveAll(planSaveDtoList)

        //when
        val list = travelPlanRepository!!.findAll()

        //then
        Assertions.assertThat(list[0].place).isEqualTo("대학로2")
    }
}