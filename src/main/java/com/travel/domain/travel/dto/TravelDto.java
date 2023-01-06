package com.travel.domain.travel.dto;

import com.travel.domain.travel.domain.Travel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TravelDto {
    private Long id;
    private String name;
    private String userId;
    private String travelStartDate;
    private String travelEndDate;

    @Builder
    public TravelDto(Long id, String name, String userId, String travelStartDate, String travelEndDate) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.travelStartDate = travelStartDate;
        this.travelEndDate = travelEndDate;
    }

    public static TravelDto of(Travel travel) {
        return new TravelDto(
                travel.getId(),
                travel.getName(),
                travel.getUserId(),
                travel.getTravelStartDate(),
                travel.getTravelEndDate());
    }
}
