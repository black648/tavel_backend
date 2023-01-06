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
    private Travel travel;

    @Column
    private Long cityId;

    @Builder
    public TravelCity(Long cityId) {
        this.cityId = cityId;
    }

    public void update(TravelCityDto travelCityDto) {
        this.cityId = travelCityDto.getCityId();
    }
}
