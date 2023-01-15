package com.travel.domain.city.domain.log

import org.springframework.data.jpa.repository.JpaRepository

interface CityLogRepository: JpaRepository<CityLog, Long> {
}