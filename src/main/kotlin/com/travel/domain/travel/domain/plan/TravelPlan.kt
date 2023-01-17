package com.travel.domain.travel.domain.plan

import com.travel.domain.travel.domain.JavaTravel
import com.travel.global.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "travelPlan")
class TravelPlan(
        @Column(name = "travelId")
        val travelId: Long,

        @Column
        val travelDate: String,

        @Column
        val place: String,

        @Column
        val orderNo: Int,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "travelId", insertable = false, updatable = false)
        val travel: JavaTravel,
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
): BaseEntity() {
    

    

    
}