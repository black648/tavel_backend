package com.travel.domain.travel.dto.plan;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TravelPlanUpdateDto {
    private String place;
    private int orderNo;

    @Builder
    public TravelPlanUpdateDto(String place, int orderNo) {
        this.place = place;
        this.orderNo = orderNo;
    }
}
