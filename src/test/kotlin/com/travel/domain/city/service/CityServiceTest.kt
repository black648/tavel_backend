package com.travel.domain.city.service

import com.travel.domain.city.domain.CityCategory
import com.travel.domain.city.domain.CityRepository
import com.travel.domain.city.dto.CitySaveDto
import com.travel.domain.city.dto.CityUpdateDto
import com.travel.domain.travel.dto.city.TravelCityDto
import com.travel.domain.travel.service.TravelCityService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class CityServiceTest {
    @Autowired
    var cityService: CityService? = null

    @Autowired
    var travelCityService: TravelCityService? = null

    @Autowired
    var cityRepository: CityRepository? = null
//    @AfterEach
//    fun clean() {
//        cityRepository!!.deleteAll()
//    }

    @DisplayName("[단위테스트] 도시명 등록")
    @Test
    fun save() {
        //given
        cityService?.save(CitySaveDto("제천", CityCategory.CHUNGCHEONG))

    }

    @DisplayName("[단위테스트] 도시명 수정")
    @Test
    fun update() {
        //given
        cityService!!.save(CitySaveDto("서울", CityCategory.SEOUL))

        //when
        cityService!!.update(38L, CityUpdateDto("성남", CityCategory.GYEONGGI))

    }

}