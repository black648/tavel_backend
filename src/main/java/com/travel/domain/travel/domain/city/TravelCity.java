package com.travel.domain.travel.domain.city;

import com.travel.domain.travel.domain.Travel;
import com.travel.domain.travel.dto.city.TravelCityDto;
import com.travel.global.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name="travelCity")
public class TravelCity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "travelId", insertable = false, updatable = false)
    private Travel travel;

    @Column(name = "travelId")
    private Long travelId;

    @Column
    private Long cityId;

    @Column
    private int orderNo;

    @Builder
    public TravelCity(Long travelId, Long cityId, int orderNo) {
        this.travelId = travelId;
        this.cityId = cityId;
        this.orderNo = orderNo;
    }

    public void update(Long cityId) {
        this.cityId = cityId;
    }
}
