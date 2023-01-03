package com.travel.domain.city.dto.request;

import com.travel.domain.city.domain.City;
import com.travel.domain.city.domain.CityCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CitySaveRequestDto {
    private String name;
    private CityCategory category;

    @Builder
    public CitySaveRequestDto(String name, CityCategory category) {
        this.name = name;
        this.category = category;
    }

    public City toEntity() {
        return City.builder()
                .name(name)
                .category(category)
                .build();
    }
}
