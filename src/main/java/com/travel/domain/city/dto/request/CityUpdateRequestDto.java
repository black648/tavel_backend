package com.travel.domain.city.dto.request;

import com.travel.domain.city.domain.CityCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CityUpdateRequestDto {

    private Long id;
    private String name;
    private CityCategory category;

    @Builder
    public CityUpdateRequestDto(Long id, String name, CityCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
