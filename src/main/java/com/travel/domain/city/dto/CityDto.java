package com.travel.domain.city.dto;

import com.travel.domain.city.domain.City;
import com.travel.domain.city.domain.CityCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private CityCategory category;

    @Builder
    public CityDto(Long id, String name, CityCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public static CityDto of(City city) {
        return new CityDto(
                city.getId(),
                city.getName(),
                city.getCategory()
        );
    }
}
