package com.travel.domain.travel.domain

import org.springframework.data.jpa.repository.JpaRepository

interface TravelRepository: JpaRepository<Travel, Long> {
}