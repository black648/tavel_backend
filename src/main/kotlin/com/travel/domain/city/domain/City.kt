package com.travel.domain.city.domain

import com.travel.domain.city.dto.CityUpdateDto
import com.travel.global.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "city")
class City constructor(
        @Column(unique = true)
        var name: String,

        @Column
        @Enumerated(EnumType.STRING)
        var category: CityCategory,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null

) : BaseEntity() {
    fun update(cityUpdateDto: CityUpdateDto) {
        this.name = cityUpdateDto.name
        this.category = cityUpdateDto.category
    }
}