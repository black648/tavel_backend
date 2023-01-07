package com.travel.domain.city.dto.log;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CityLogSaveDto {
    private Long cityId;
    private String userId;

    @Builder
    public CityLogSaveDto(Long cityId) {
        this.cityId = cityId;
    }
}
