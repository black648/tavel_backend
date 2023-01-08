package com.travel.domain.travel.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TravelUpdateDto {
    private Long id;
    private String name;
    private String travelStartDate;
    private String travelEndDate;

    @Builder
    public TravelUpdateDto(String name, String travelStartDate, String travelEndDate) {
        this.name = name;
        this.travelStartDate = travelStartDate;
        this.travelEndDate = travelEndDate;
    }
}
