package com.travel.domain.travel.domain.city

import com.travel.domain.travel.domain.Travel
import com.travel.global.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "travelCity")
class TravelCity(
        @Column(name = "travelId")
        var travelId: Long,

        @Column
        var cityId: Long,

        @Column
        var orderNo: Int,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "travelId", insertable = false, updatable = false)
        val travel: Travel? = null,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
): BaseEntity() {
    fun update(cityId: Long) {
        this.cityId = cityId
    }
}