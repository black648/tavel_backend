package com.travel.domain.travel.domain

import com.travel.domain.travel.domain.city.TravelCity
import com.travel.domain.travel.domain.plan.TravelPlan
import com.travel.domain.travel.dto.JavaTravelUpdateDto
import com.travel.global.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "travel")
class Travel(
        @Column
        var name: String,

        @Column
        val userId: String,

        @Column
        var travelStartDate: String,

        @Column
        var travelEndDate: String,

        @OneToMany(mappedBy = "travel", cascade = [CascadeType.ALL], orphanRemoval = true)
        val travelPlanList: List<TravelPlan> = mutableListOf(),

        @OneToMany(mappedBy = "travel", cascade = [CascadeType.ALL], orphanRemoval = true)
        val travelCityList: List<TravelCity> = mutableListOf(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
): BaseEntity() {
        fun update(travelUpdateDto: JavaTravelUpdateDto) {
                this.name = travelUpdateDto.name
                this.travelStartDate = travelUpdateDto.travelStartDate
                this.travelEndDate = travelUpdateDto.travelEndDate
        }
}