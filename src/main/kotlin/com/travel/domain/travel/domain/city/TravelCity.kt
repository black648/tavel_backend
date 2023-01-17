package com.travel.domain.travel.domain.city

import com.travel.domain.travel.domain.JavaTravel
import com.travel.global.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "travelCity")
class TravelCity(
        @Column(name = "travelId")
        val travelId: Long,

        @Column
        var cityId: Long,

        @Column
        val orderNo: Int,
        
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "travelId", insertable = false, updatable = false)
        val travel: JavaTravel,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
): BaseEntity() {
    fun update(cityId: Long) {
        this.cityId = cityId
    }
}