package com.travel.domain.city.domain.log;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="cityLog")
public class CityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long cityId;

    @Column
    private String userId;

    @CreatedDate
    private LocalDateTime createDate;

    @Builder
    public CityLog(Long cityId) {
        this.cityId = cityId;
    }

    public CityLog toEntity() {
        return CityLog.builder()
                .cityId(cityId)
                .build();
    }
}
