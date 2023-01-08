package com.travel.domain.travel.dto.city;

import com.travel.domain.travel.domain.city.TravelCity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TravelCityDto {
    private Long travelId;
    private Long cityId;

    @Builder
    public TravelCityDto(Long travelId, Long cityId) {
        this.travelId = travelId;
        this.cityId = cityId;
    }

    public TravelCity toEntity() {
        return TravelCity.builder()
                .travelId(travelId)
                .cityId(cityId)
                .build();
    }
}
