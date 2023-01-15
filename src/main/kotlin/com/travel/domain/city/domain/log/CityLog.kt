package com.travel.domain.city.domain.log

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "cityLog")
class CityLog constructor(
        @Column
        val cityId: Long,

        @Column
        val userId: String,

        @CreatedDate
        val createDate: LocalDateTime,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
) {
}
